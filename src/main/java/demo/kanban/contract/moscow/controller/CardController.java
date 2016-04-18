package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import demo.kanban.contract.moscow.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xchou on 4/17/16.
 */
@RestController
@RequestMapping("/column/{columnId}/cards/")
public class CardController {

    @Autowired
    CardService cardService;

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public HttpEntity<List<CardResource>> getAllCards(@PathVariable String columnId) {

        cardService.getCardInColumn(columnId);
        List<Card> cards = Arrays.asList(new Card("card_1", "card 1"), new Card("card_2", "card 2"), new Card("card_3", "card 3"));
        CardResourceAssembler cardAssembler = new CardResourceAssembler();
        List<CardResource> cardResources = cardAssembler.toResources(cards);
        return new ResponseEntity<>(cardResources, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json")
    public HttpEntity<CardResource> saveCard(@RequestBody Card card) {

        cardService.saveCard(card);
        CardResourceAssembler cardAssembler = new CardResourceAssembler();
        CardResource cardResource = cardAssembler.toResource(card);
        return new ResponseEntity<>(cardResource, HttpStatus.OK);
    }

    @RequestMapping(path = "/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<CardResource> getCardById(@PathVariable String cardId) {

        Card card = new Card(cardId, "card 1");
        card.setId("1");
        List<Card> children = Arrays.asList(new Card("child_1", "child One"));
        Card parent = new Card("Parent card", "parent ccarddd");
        card.setParent(parent);
        card.setChildren(children);
        CardResourceAssembler cardAssembler = new CardResourceAssembler();
        CardResource cardResource = cardAssembler.toResource(card);
        return new ResponseEntity<>(cardResource, HttpStatus.OK);
    }

}
