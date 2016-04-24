package demo.kanban.contract.moscow.resource.card;

import demo.kanban.contract.moscow.resource.column.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import java.util.HashMap;

/**
 * Created by xchou on 4/17/16.
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "cards")
public class Card implements Identifiable<String> {

    @Id
    private String id;

    private HashMap<String, Object> metadata = new HashMap<>();

    private boolean inRisk;

    @DBRef
    private Column column;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
