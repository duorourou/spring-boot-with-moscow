package demo.kanban.contract.moscow.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

/**
 * Created by xchou on 4/12/16.
 */
@Getter
@Setter
@EqualsAndHashCode(of = "userId" , callSuper = false)
@Document(collection = "users")
public class UserResource extends ResourceSupport implements Serializable {

    @Id
    private String userId;
    private String name;
    private String avatarUri;
    private Integer age;
    private String both;

    public UserResource() {
    }

    @JsonCreator
    @JsonIgnoreProperties(ignoreUnknown = true)
    public UserResource(@JsonProperty(value = "userId") String userId, @JsonProperty(value = "name") String name) {
        this.userId = userId;
        this.name = name;
    }

}
