package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.column.Column;
import demo.kanban.contract.moscow.resource.column.ColumnResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/17/16.
 */
public class ColumnResourceAssembler extends ResourceAssemblerSupport<Column, ColumnResource> {
    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     *
     */
    public ColumnResourceAssembler( ) {
        super(ColumnController.class, ColumnResource.class);
    }

    @Override
    public ColumnResource toResource(Column column) {
        return new ColumnResource(column ,linkTo(methodOn(ColumnController.class).getColumnById(column.getId())).withSelfRel());
    }
}
