package com.nestgroup.TODO.App.Backend.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TodoDao extends CrudRepository<TodoModel,Integer> {

    @Query(value = "SELECT * FROM `todos` t where t.user_id = :user_id order by start_date desc",nativeQuery = true)
    List<Map<String,String>> findAll(int user_id);


    @Modifying
    @Query(value = "Update todos set status = :status where id = :id",nativeQuery = true)
    void changeStatus(Integer id,boolean status);
}
