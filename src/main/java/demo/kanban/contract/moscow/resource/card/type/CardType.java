package demo.kanban.contract.moscow.resource.card.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import java.util.List;

/**
 * Created by xchou on 5/12/16.
 */
@Document(collection = "cardTypes")
public class CardType implements Identifiable<String> {

    private String id;
    private String name;
    @JsonIgnore
    private List<CardAttribute> attributeList;
    private List<String> cardAttributes;
    private List<String> customizedAttributes;

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CardAttribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<CardAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    public List<String> getCardAttributes() {
        return cardAttributes;
    }

    public void setCardAttributes(List<String> cardAttributes) {
        this.cardAttributes = cardAttributes;
    }

    public List<String> getCustomizedAttributes() {
        return customizedAttributes;
    }

    public void setCustomizedAttributes(List<String> customizedAttributes) {
        this.customizedAttributes = customizedAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
