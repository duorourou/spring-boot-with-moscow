package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.repository.ColumnRepository;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardFields;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.resource.card.SimpleCardResource;
import demo.kanban.contract.moscow.resource.column.Column;
import demo.kanban.contract.moscow.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xchou on 4/17/16.
 */
@RestController
@RequestMapping("/column/{columnId}/cards")
public class CardController {

    int number;

    @Autowired
    CardService cardService;

    @Autowired
    ColumnRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public PagedResources<SimpleCardResource> getAllCards(@PathVariable String columnId) {
//        mockCardData(columnId);
        return cardService.getCardInColumn(columnId);
    }

    @RequestMapping(path = "/spec", method = RequestMethod.GET, produces = "application/json")
    public List<SimpleCardResource> getCards(@PathVariable String columnId) {
//        mockCardData(columnId);
        return cardService.getCardsInColumn(columnId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CardResource saveCard(@PathVariable String columnId, @RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @RequestMapping(path = "/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CardResource getCardById(@PathVariable String columnId, @PathVariable String cardId) {
        return cardService.getCardById(cardId);
    }

    private void mockCardData(String columnId) {

        Column column = new Column();
        column.setId(columnId);
        repository.save(column);

        HashMap<String, Object> metadata = new HashMap<>();
        metadata.put(CardFields.CARD_NUMBER , "card-" + number++);
        metadata.put(CardFields.CARD_TYPE , "story");
        metadata.put(CardFields.CARD_TITLE , "card-" + number++);
        metadata.put(CardFields.CARD_LEAD_TIME , new Date());
        metadata.put(CardFields.CARD_IN_COLUMN_TIME , new Date());
        metadata.put(CardFields.CARD_DELIVERY_DATE , new Date());
        metadata.put(CardFields.CARD_DESCRIPTION , "card-" + number++);
        metadata.put(CardFields.CARD_OWNER , "card-" + number++);
        metadata.put(CardFields.CARD_PARENT , "card-" + number++);
        metadata.put(CardFields.CARD_PROGRESS , "card-" + number++);
        metadata.put(CardFields.CARD_START_DATE , new Date());
        metadata.put(CardFields.CARD_IN_RISK , true);

        Card card = new Card();
        card.setMetadata(metadata);
        card.setInRisk(true);

        card.setColumn(column);

        cardService.saveCard(card);
    }

}
