package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.card.Card;
import demo.kanban.contract.moscow.resource.card.SimpleCardResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/20/16.
 */
public class SimpleCardResourceAssembler extends ResourceAssemblerSupport<Card, SimpleCardResource> {
    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    List<String> customizedFields = new ArrayList<>();

    public SimpleCardResourceAssembler(List<String> customizedFields) {
        super(CardController.class, SimpleCardResource.class);
        this.customizedFields = customizedFields;
    }

    @Override
    public SimpleCardResource toResource(Card entity) {

        return new SimpleCardResource(entity,
                customizedFields,
                linkTo(methodOn(CardController.class).getCardById(entity.getColumn().getId() , entity.getId())).withSelfRel()
                );
    }
}
