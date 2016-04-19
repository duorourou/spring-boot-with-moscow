package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.repository.ColumnRepository;
import demo.kanban.contract.moscow.resource.card.*;
import demo.kanban.contract.moscow.resource.column.Column;
import demo.kanban.contract.moscow.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public Resources<CardResource> getAllCards(@PathVariable String columnId) {
        mockCardData(columnId);
        return cardService.getCardInColumn(columnId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CardResource saveCard(@PathVariable String columnId, @RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @RequestMapping(path = "/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CardResource getCardById(@PathVariable String columnId, @PathVariable String cardId) {
        return cardService.getCardById(cardId);
    }

    private Card mockCardData(String columnId) {

        Column column = new Column();
        column.setId(columnId);
        repository.save(column);

        CardRelations cardRelations = new CardRelations();

        CardRisk risk = new CardRisk();
        risk.setRiskType("block");
        risk.setRiskDescription("blocked by another story!");

        CardMetadata metadata = new CardMetadata();
        metadata.setCardId("card-" + number++);
        metadata.setType("story");
        metadata.setTitle("card title - " + number++);
        metadata.setDeliveryDate(new Date());


        Card card_1 = new Card();
        card_1.setColumn(column);
        card_1.setMetadata(metadata);
        card_1.setRisk(risk);
        cardService.saveCard(card_1);

        Card card_2 = new Card();
        card_2.setColumn(column);
        metadata.setCardId("card-" + number++);
        metadata.setTitle("card title - " + number++);
        card_2.setMetadata(metadata);
        card_2.setRisk(risk);
        cardRelations.setParent(card_1);
        card_2.setRelations(cardRelations);
        cardService.saveCard(card_2);


        Card card_3 = new Card();
        card_3.setColumn(column);
        metadata.setCardId("card-" + number++);
        metadata.setTitle("card title - " + number++);
        card_3.setMetadata(metadata);
        card_3.setRisk(risk);
        cardRelations.setParent(card_1);
        card_3.setRelations(cardRelations);
        cardService.saveCard(card_3);


        Card card_4 = new Card();
        card_4.setColumn(column);
        metadata.setCardId("card-" + number++);
        metadata.setTitle("card title - " + number++);
        card_4.setMetadata(metadata);
        card_4.setRisk(risk);
        cardRelations.setParent(card_3);
        card_4.setRelations(cardRelations);
        cardService.saveCard(card_4);


        Card card_5 = new Card();
        card_5.setColumn(column);
        metadata.setCardId("card-" + number++);
        metadata.setTitle("card title - " + number++);
        card_5.setMetadata(metadata);
        card_5.setRisk(risk);
        cardRelations.setParent(card_4);
        card_5.setRelations(cardRelations);
        cardService.saveCard(card_5);


        Card card_6 = new Card();
        card_6.setColumn(column);
        metadata.setCardId("card-" + number++);
        metadata.setTitle("card title - " + number++);
        card_6.setMetadata(metadata);
        card_6.setRisk(risk);
        cardRelations.setParent(card_4);
        card_6.setRelations(cardRelations);
        cardService.saveCard(card_6);

        return card_1;
    }

}
