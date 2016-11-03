package demo.kanban.contract.moscow.service;

import demo.kanban.contract.moscow.repository.UserRepository;
import demo.kanban.contract.moscow.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xchou on 4/15/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public UserResource saveUser(UserResource userResource) {
        return repository.save(userResource);
    }

    @Override
    public UserResource getUserById(Integer userId) {
        return repository.findOne(userId);
    }

    @Override
    public UserResource getUserByName(String userName) {
        return repository.findByName(userName);
    }

    @Override
    public List<UserResource> getAllUsers() {
        return repository.findAll();
    }
}
