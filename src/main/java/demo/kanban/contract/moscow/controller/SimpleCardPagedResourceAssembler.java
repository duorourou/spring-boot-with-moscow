package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.card.Card;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/20/16.
 */
public class SimpleCardPagedResourceAssembler extends PagedResourcesAssembler<Card> {

    public SimpleCardPagedResourceAssembler(Integer columnId) {
        super(null, linkTo(methodOn(CardController.class).getAllCards(null, columnId)).toUriComponentsBuilder().build());
    }
}
