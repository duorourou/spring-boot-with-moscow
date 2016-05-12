package demo.kanban.contract.moscow.resource.card.type;

import java.io.Serializable;

/**
 * Created by xchou on 5/12/16.
 */
public class CardAttribute implements Serializable {

    private String name;
    private String type;
    private boolean constant;
    private Object defaultValue;
    private boolean visible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
