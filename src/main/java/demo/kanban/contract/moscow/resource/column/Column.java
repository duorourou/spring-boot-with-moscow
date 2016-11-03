package demo.kanban.contract.moscow.resource.column;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by xchou on 4/18/16.
 */
@Entity(name = "columns")
public class Column implements Persistable{

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String laneName;
    private String laneDesc;
    @CreatedDate
    private Date createdAt;

    public Integer getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public Column(Integer id) {
        this.id = id;
    }

    public Column() {
    }

    public Column(String laneName, String laneDesc) {
        this.laneName = laneName;
        this.laneDesc = laneDesc;
    }

    public void setId(Integer id) {
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
