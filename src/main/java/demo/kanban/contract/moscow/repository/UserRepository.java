package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.UserResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserResource, String>{

    UserResource findByName(String name);

}
