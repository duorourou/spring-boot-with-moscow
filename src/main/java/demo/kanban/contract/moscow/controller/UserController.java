package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.UserResource;
import demo.kanban.contract.moscow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xchou on 4/12/16.
 */
@RestController
@ExposesResourceFor(UserResource.class)
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public HttpEntity<UserResource> getMoscow(@PathVariable Integer userId) {
        UserResource userResource = userService.getUserById(userId);
        return new ResponseEntity(userResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<UserResource> saveUser(@RequestBody UserResource userResourceIn) {
        UserResource userResource = userService.saveUser(userResourceIn);
//        userResource.add(linkTo(methodOn(UserController.class).getMoscow(userResource.getUserId())).withSelfRel());
        return new ResponseEntity(userResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<UserResource> getUsers() {
        List<UserResource> userResources = userService.getAllUsers();
        return new ResponseEntity(userResources, HttpStatus.OK);
    }
}
