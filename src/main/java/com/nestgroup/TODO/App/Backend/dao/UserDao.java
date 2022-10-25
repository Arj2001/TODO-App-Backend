package com.nestgroup.TODO.App.Backend.dao;

import com.nestgroup.TODO.App.Backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {


    @Query(value = "select * from users where email = :email and password = :password",nativeQuery = true)
    List<UserModel> find(String email,String password);
}
