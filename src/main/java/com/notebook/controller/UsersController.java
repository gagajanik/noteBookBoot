package com.notebook.controller;

import com.notebook.dao.UsersDao;
import com.notebook.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 3/4/18.
 */
@RestController
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersDao usersDao;
    @RequestMapping("/createUser")
    public Users createUser(@RequestBody  Users users){
           return usersDao.save(users);
    }

    @RequestMapping(value = "/api/auth")
    public Users checkUsers(@RequestBody Users users){
        return usersDao.findFirstByUserNameAndPassword(users.getUserName(), users.getPassword());
    }
}
