package demo.kanban.contract.moscow.service;

import demo.kanban.contract.moscow.resource.UserResource;

import java.util.List;

/**
 * Created by xchou on 4/12/16.
 */
public interface UserService {

    UserResource saveUser(UserResource userResource);

    UserResource getUserById(String userId);

    UserResource getUserByName(String userName);

    List<UserResource> getAllUsers();
}
