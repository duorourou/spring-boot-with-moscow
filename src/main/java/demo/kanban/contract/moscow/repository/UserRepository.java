package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.UserResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xchou on 4/12/16.
 */
@Repository
public interface UserRepository extends MongoRepository<UserResource, String>{

    UserResource findByName(String name);

}
