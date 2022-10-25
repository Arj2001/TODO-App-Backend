package com.nestgroup.TODO.App.Backend.controller;

import com.nestgroup.TODO.App.Backend.dao.UserDao;
import com.nestgroup.TODO.App.Backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/addUser",consumes = "application/json",produces = "application/json")
    public void addUserValue(@RequestBody UserModel userModel){
        userDao.save(userModel);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/auth",consumes = "application/json",produces = "application/json")
    public List<UserModel> authenticate(@RequestBody UserModel userModel){
        return (List<UserModel>) userDao.find(userModel.getEmail(),userModel.getPassword());
    }

}
