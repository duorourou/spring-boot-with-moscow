package demo.kanban.contract.moscow.resource.card;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by xchou on 4/19/16.
 */
@Getter
@Setter
public class CardRisk implements Serializable {

    private String riskType;
    private String riskDescription;

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }
}
