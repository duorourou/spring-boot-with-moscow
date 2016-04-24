package demo.kanban.contract.moscow.resource.card;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.hateoas.Identifiable;

@Document(collection = "kanban_sequences")
public class KanbanSequence implements Identifiable<String>{
    @Id
    @Field("card_number")
    private String id;

    private long seq;
    @Override
    public String getId() {
        return this.getId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
