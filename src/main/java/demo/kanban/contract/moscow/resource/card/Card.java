package demo.kanban.contract.moscow.resource.card;

import demo.kanban.contract.moscow.resource.column.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * Created by xchou on 4/17/16.
 */
@Document(collection = "cards")
public class Card implements Identifiable<String> {

    private static final Logger logger = LoggerFactory.getLogger(Card.class);

    @Id
    private String id;

    private String number;

    private HashMap<String, Object> metadata = new HashMap<>();

    @NotNull
    private boolean inRisk;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    private boolean deleted = false;

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    @NotNull
    @Size(max = 10 , min = 3)
    private String risk;


    @DBRef
    private Column column;

    @Cacheable(key = "#{column.id}")
    public Column getColumn() {

        logger.info("column id : " + column.getId());
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public Card() {
    }

    public Card(int number) {
        this.number = "Story - " + number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String, Object> metadata) {
        this.metadata = metadata;
    }

    public boolean isInRisk() {
        return inRisk;
    }

    public void setInRisk(boolean inRisk) {
        this.inRisk = inRisk;
    }
}
