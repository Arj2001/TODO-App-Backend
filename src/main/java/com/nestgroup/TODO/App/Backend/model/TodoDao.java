package com.nestgroup.TODO.App.Backend.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TodoDao extends CrudRepository<TodoModel,Integer> {

    @Query(value = "SELECT * FROM `todos` t where t.user_id = :user_id",nativeQuery = true)
    List<Map<String,String>> findAll(int user_id);
}
