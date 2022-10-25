package com.nestgroup.TODO.App.Backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoModel {

    @Id
    @GeneratedValue
    private int id;

    private int user_id;
    private String todo_name,todo_description,due_date,start_date;
    private boolean status;
}
