package demo.kanban.contract.moscow.resource.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import java.util.Date;
import java.util.List;

/**
 * Created by xchou on 4/17/16.
 */
public class CardResource extends Resource<Card>{

    private String type;
    private String owner;
    private List<String> assigners;
    private String title;
    private String risk;
    private Card parent;
    private List<Card> children;
    private Date deliveryDate;

    public CardResource(Card content, Link... links) {
        super(content, links);
        this.type = content.getType();
        this.owner = content.getOwner();
        this.assigners = content.getAssigners();
    }

    @Override
    @JsonIgnore
    public Card getContent() {
        return super.getContent();
    }
}
