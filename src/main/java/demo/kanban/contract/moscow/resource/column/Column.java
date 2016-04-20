package demo.kanban.contract.moscow.resource.column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import java.util.Date;

/**
 * Created by xchou on 4/18/16.
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "columns")
public class Column implements Identifiable<String> {

    @Id
    private String id;

    @JsonIgnore
    private String laneName;
    @JsonIgnore
    private String laneDesc;
    @JsonIgnore
    private Date createdAt;

    @Override
    public String getId() {
        return this.id;
    }

    public Column() {
    }

    public Column(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getLaneDesc() {
        return laneDesc;
    }

    public void setLaneDesc(String laneDesc) {
        this.laneDesc = laneDesc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
