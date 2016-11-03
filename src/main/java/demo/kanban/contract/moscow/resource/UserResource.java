package demo.kanban.contract.moscow.resource;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xchou on 4/12/16.
 */
@Getter
@Setter
@EqualsAndHashCode(of = "userId" , callSuper = false)
@Entity(name = "users")
public class UserResource {

    @Id
    private Integer userId;
    private String name;
    private String avatarUri;
    private Integer age;
    private String birth;

    public UserResource() {
    }

}
