package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.repository.ColumnRepository;
import demo.kanban.contract.moscow.resource.UserResource;
import demo.kanban.contract.moscow.resource.column.Column;
import demo.kanban.contract.moscow.resource.column.ColumnResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by xchou on 4/12/16.
 */
@RestController
@ExposesResourceFor(UserResource.class)
@RequestMapping("/columns")
public class ColumnController {

    @Autowired
    ColumnRepository columnRepository;

    @RequestMapping(value = "/{columnId}/", method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<ColumnResource> getColumnById(@PathVariable String columnId) {
        Column column = columnRepository.findOne(columnId);
        ColumnResource columnResource = new ColumnResourceAssembler().toResource(column);
        return new ResponseEntity(columnResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public HttpEntity<ColumnResource> saveColumn(@Valid @RequestBody Column column) {
        columnRepository.save(column);
        ColumnResource columnResource = new ColumnResourceAssembler().toResource(column);
        return new ResponseEntity(columnResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<UserResource> getAllColumns() {
        List<Column> columnList = columnRepository.findAll();
        List<ColumnResource> columnResources = new ColumnResourceAssembler().toResources(columnList);
        return new ResponseEntity(columnResources, HttpStatus.OK);
    }
}
