package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.integration.AutoUpdateConf;
import demo.kanban.contract.moscow.repository.ColumnRepository;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.resource.card.SimpleCardResource;
import demo.kanban.contract.moscow.resource.column.Column;
import demo.kanban.contract.moscow.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by xchou on 4/17/16.
 */
@RestController
@RequestMapping("/columns/{columnId}/cards")
public class CardController {

    int number;

    @Autowired
    CardService cardService;

    @Autowired
    ColumnRepository repository;

    @Autowired
    AutoUpdateConf conf;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public PagedResources<SimpleCardResource> getAllCards(HttpSession session, @PathVariable Integer columnId) {
        Card card;
        Column column = new Column();
        column.setId(columnId);
        for(int i = 10; i < 20; i ++){
            card = new Card();
            card.setColumn(column);
            card.setRisk("risk " + i);
            cardService.saveCard(card);
        }
        conf.initInputChannel().send(MessageBuilder.withPayload("a").build());
        return cardService.getCardInColumn(columnId);
    }

    @RequestMapping(path = "/spec", method = RequestMethod.GET, produces = "application/json")
    public List<Card> getCards(@PathVariable Integer columnId) throws UnknownHostException {
        conf.cardInputChannel().send(MessageBuilder.withPayload("789").build());
        return cardService.getCardsInColumn(columnId);

    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CardResource saveCard(@PathVariable Integer columnId, @RequestBody @Valid Card card) {
        return cardService.saveCard(card);
    }

    @RequestMapping(path = "/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CardResource getCardById(@PathVariable Integer columnId, @PathVariable Integer cardId) {
        return cardService.getCardById(cardId);
    }

}
