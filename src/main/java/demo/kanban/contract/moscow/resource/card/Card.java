package demo.kanban.contract.moscow.resource.card;

import demo.kanban.contract.moscow.resource.column.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.hateoas.Identifiable;

import java.util.Date;
import java.util.List;

/**
 * Created by xchou on 4/17/16.
 */
@Getter
@Setter
@NoArgsConstructor
public class Card implements Identifiable<String> {

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;
    private String cardId;
    private String type;
    private String owner;
    private List<String> assigners;
    private String title;
    private String risk;
    private Card parent;
    @DBRef
    private Column column;
    @DBRef
    @Lazy(true)
    private List<Card> children;
    private Date deliveryDate;

    public Card() {
    }

    public Card(String id) {
        this.id = id;
    }

    public Card(String cardId, String title) {
        this.cardId = cardId;
        this.title = title;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Card[]";
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getAssigners() {
        return assigners;
    }

    public void setAssigners(List<String> assigners) {
        this.assigners = assigners;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public Card getParent() {
        return parent;
    }

    public void setParent(Card parent) {
        this.parent = parent;
    }

    public List<Card> getChildren() {
        return children;
    }

    public void setChildren(List<Card> children) {
        this.children = children;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
