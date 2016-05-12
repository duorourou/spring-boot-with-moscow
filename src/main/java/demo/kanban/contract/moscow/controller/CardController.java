package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.repository.ColumnRepository;
import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.resource.card.SimpleCardResource;
import demo.kanban.contract.moscow.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return cardService.getCardInColumn(columnId);
//        return cardService.getCardInColumn(columnId);
    }

    @RequestMapping(path = "/spec", method = RequestMethod.GET, produces = "application/json")
    public List<SimpleCardResource> getCards(@PathVariable String columnId) {
//        mockCardData(columnId);
        return cardService.getCardsInColumn(columnId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CardResource saveCard(@PathVariable String columnId, @RequestBody @Valid Card card) {
        return cardService.saveCard(card);
    }

    @RequestMapping(path = "/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CardResource getCardById(@PathVariable String columnId, @PathVariable String cardId) {
        return cardService.getCardById(cardId);
    }

}
