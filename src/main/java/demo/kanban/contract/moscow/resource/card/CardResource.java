package demo.kanban.contract.moscow.resource.card;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

/**
 * Created by xchou on 4/17/16.
 */
public class CardResource extends Resource<Card>{

    public CardResource(Card content, Link... links) {
        super(content, links);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
