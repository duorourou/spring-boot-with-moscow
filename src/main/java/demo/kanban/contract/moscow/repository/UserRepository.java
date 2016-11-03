package demo.kanban.contract.moscow.repository;

import demo.kanban.contract.moscow.resource.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserResource, Integer> {

    UserResource findByName(String name);

}
