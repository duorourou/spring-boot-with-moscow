package demo.kanban.contract.moscow.resource.card;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;

/**
 * Created by xchou on 4/19/16.
 */
public class CardRelations implements Serializable{

    @DBRef
    private Card parent;

    public Card getParent() {
        return parent;
    }

    public void setParent(Card parent) {
        this.parent = parent;
    }
}
