package com.assecor.usermanager.controller;

import com.assecor.usermanager.bean.User;
import com.assecor.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserManagerController {


    @Autowired
    private UserService userService;

    @RequestMapping("/persons")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @RequestMapping("/persons/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.getSpecificUser(id);
    }

    @RequestMapping("/persons/color/{color}")
    public List<User> getAllUsersByColour(@PathVariable String color) {
        return userService.getUsersByColour(color);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/persons")
    public User createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return createdUser;
    }

}
