package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.CardResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/17/16.
 */
public class CardResourceAssembler extends ResourceAssemblerSupport<Card, CardResource> {
    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     *
     */
    public CardResourceAssembler() {
        super(CardController.class, CardResource.class);
    }

    @Override
    public CardResource toResource(Card card) {
        return new CardResource(card ,linkTo(methodOn(CardController.class).getCardById(card.getCardId())).withSelfRel());
    }
}
