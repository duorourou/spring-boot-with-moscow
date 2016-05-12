package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.repository.CardTypeRepository;
import demo.kanban.contract.moscow.resource.card.type.CardAttribute;
import demo.kanban.contract.moscow.resource.card.type.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xchou on 5/12/16.
 */
@RestController
@RequestMapping(path = "/cardTypes")
public class CardTypeController {

    @Autowired
    CardTypeRepository repository;

    @RequestMapping(method = RequestMethod.GET  )
    public List<CardType> getCardTypes() {
        return repository.findAll();
    }

    @RequestMapping(path = "/customizedFields")
    public List<CardAttribute> getCustomizedFields() {
        CardType type = repository.findAll().get(0);
        return type.getAttributeList().stream().filter(s -> s.isVisible())
                .filter(s -> type.getCustomizedAttributes().contains(s.getName()))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/attributes")
    public List<CardAttribute> getAllAttributes() {
        CardType type = repository.findAll().get(0);
        return type.getAttributeList().stream().filter(s -> s.isVisible())
                .filter(s -> type.getCardAttributes().contains(s.getName()))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/add/{name}", method = RequestMethod.GET)
    public List<CardType> createCardType(@PathVariable String name) {
        CardType type = new CardType();
        type.setName(name);
        type.setCardAttributes(Arrays.asList("Lead Time", "Estimation", "Release", "Owner", "Type", "Due Date"));
        type.setCustomizedAttributes(Arrays.asList("Estimation", "Release", "Due Date"));
        type.setAttributeList(getAttributes());
        repository.save(type);
        return repository.findAll();
    }

    private List<CardAttribute> getAttributes() {
        CardAttribute leadTime = new CardAttribute();
        leadTime.setName("Lead Time");
        leadTime.setConstant(true);
        leadTime.setDefaultValue(0);
        leadTime.setType("Text");
        leadTime.setVisible(true);
        CardAttribute estimation = new CardAttribute();
        estimation.setName("Estimation");
        estimation.setConstant(true);
        estimation.setDefaultValue(0);
        estimation.setType("Text");
        estimation.setVisible(true);
        CardAttribute release = new CardAttribute();
        release.setName("Release");
        release.setConstant(true);
        release.setDefaultValue(null);
        release.setType("Text");
        release.setVisible(true);
        CardAttribute owner = new CardAttribute();
        owner.setName("Owner");
        owner.setConstant(true);
        owner.setDefaultValue(null);
        owner.setType("Text");
        owner.setVisible(true);
        CardAttribute type = new CardAttribute();
        type.setName("Type");
        type.setConstant(true);
        type.setDefaultValue(null);
        type.setType("Text");
        type.setVisible(true);
        CardAttribute dueDate = new CardAttribute();
        dueDate.setName("Due Date");
        dueDate.setConstant(true);
        dueDate.setDefaultValue("");
        dueDate.setType("Date");
        dueDate.setVisible(true);
        return Arrays.asList(leadTime, estimation, owner, release, type, dueDate);
    }
}
