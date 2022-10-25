package com.nestgroup.TODO.App.Backend.controller;

import com.nestgroup.TODO.App.Backend.model.TodoDao;
import com.nestgroup.TODO.App.Backend.model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class TodoController {

    @Autowired
    private TodoDao todoDao;

    @CrossOrigin(origins = "*")
    @PostMapping("/addTodo")
    public String addTodoList(@RequestBody TodoModel todoModel){
        todoModel.setStatus(false);
        DateTimeFormatter datetime=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        todoModel.setStart_date(String.valueOf(datetime.format(now)));
        todoDao.save(todoModel);
        return "Success";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/viewTodo")
    public List<Map<String,String>> viewTodoByUserId(@RequestBody TodoModel todoModel){
        return (List<Map<String,String>>) todoDao.findAll(todoModel.getUser_id());
    }
}
