package demo.kanban.contract.moscow.resource.card;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by xchou on 4/20/16.
 */
public class SimpleCard implements Serializable {

    private Integer id;

    private HashMap<String, Object> metadata = new HashMap<>();

    private HashMap<String , Object> customizedFields = new HashMap<>();

    public Integer getId() {
        return id;
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

    public HashMap<String, Object> getCustomizedFields() {
        return customizedFields;
    }

    public void setCustomizedFields(HashMap<String, Object> customizedFields) {
        this.customizedFields = customizedFields;
    }
}
