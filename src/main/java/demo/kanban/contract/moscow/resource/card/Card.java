package demo.kanban.contract.moscow.resource.card;

import demo.kanban.contract.moscow.resource.column.Column;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * Created by xchou on 4/17/16.
 */
@Getter
@Entity(name = "cards")
public class Card {

    private static final Logger logger = LoggerFactory.getLogger(Card.class);

    @Id
    @GeneratedValue
    private Integer id;

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


    @ManyToOne(targetEntity = Column.class)
    private Column column;

    public Column getColumn() {

        logger.info("column id : " + column.getId());
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public Card() {
    }

    public Card(int number) {
        this.number = "Story - " + number;
    }

    public void setId(Integer id) {
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
