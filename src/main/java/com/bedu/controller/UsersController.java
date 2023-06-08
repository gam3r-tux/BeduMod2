package com.bedu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bedu.model.Users;
import com.bedu.service.UsersService;

/*
 * Controller for CRUD operations for user entity
 * author : Jose Ramos Briseno
 * date:    07-06-2023
 */

//mark class as Controller
@RestController
public class UsersController 
{
    // logger
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    //autowire the UsersService class
    @Autowired
    UsersService usersService;
    //creating a get mapping that retrieves all the users detail from the database 
    @GetMapping("/user")
    private List<Users> getAllUsers() 
    {
        logger.info("GetAll existing users");
        return usersService.getAllUsers();
    }
    //creating a get mapping that retrieves the detail of a specific user
    @GetMapping("/user/{userid}")
    private Users getUsers(@PathVariable("userid") int userid) 
    {
        logger.info("GetBy ID a user");
        return usersService.getUsersById(userid);
    }
    //creating a delete mapping that deletes a specified user
    @DeleteMapping("/user/{userid}")
    private void deleteUser(@PathVariable("userid") int userid) 
    {
        logger.info("Delete a user");
        usersService.delete(userid);
    }
    //creating post mapping that post the user detail in the database
    @PostMapping("/users")
    private int saveUser(@RequestBody Users users) 
    {
        logger.info("Insert a new user");
        usersService.saveOrUpdate(users);
        return users.getUserid();
    }
    //creating put mapping that updates the user detail 
    @PutMapping("/users")
    private Users update(@RequestBody Users users) 
    {
        logger.info("Update a user");
        usersService.saveOrUpdate(users);
        return users;
    }
}
