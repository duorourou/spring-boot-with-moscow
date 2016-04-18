package demo.kanban.contract.moscow.controller;

import demo.kanban.contract.moscow.resource.UserResource;
import demo.kanban.contract.moscow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by xchou on 4/12/16.
 */
@RestController
@ExposesResourceFor(UserResource.class)
@RequestMapping("/user")
public class UserController {

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public HttpEntity<UserResource> getMoscow(@PathVariable String userId) {
        UserResource userResource = userService.getUserById(userId);
        userResource.add(linkTo(methodOn(UserController.class).getMoscow(userId)).withSelfRel());
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
        userResources.forEach(u -> {
            u.add(linkTo(methodOn(UserController.class).getMoscow(String.valueOf(u.getId()))).withSelfRel());
        });
        return new ResponseEntity(userResources, HttpStatus.OK);
    }
}
