package demo.kanban.contract.moscow.resource.card.type;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xchou on 5/12/16.
 */
@Getter
@Entity(name = "cardTypes")
public class CardType {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
