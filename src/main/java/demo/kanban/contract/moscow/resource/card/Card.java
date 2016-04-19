package demo.kanban.contract.moscow.resource.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import demo.kanban.contract.moscow.resource.column.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.hateoas.Identifiable;

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

    private CardMetadata metadata;
    private CardRisk risk;

    @JsonIgnore
    private CardRelations relations;

    @DBRef
    private Column column;

    public Card() {
    }

    public Card(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public CardMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CardMetadata metadata) {
        this.metadata = metadata;
    }

    public CardRisk getRisk() {
        return risk;
    }

    public void setRisk(CardRisk risk) {
        this.risk = risk;
    }

    public CardRelations getRelations() {
        return relations;
    }

    public void setRelations(CardRelations relations) {
        this.relations = relations;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
