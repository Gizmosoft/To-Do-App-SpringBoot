package com.gizmosoft.todoapp.web.controller;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseEntity<List<TodoItemBean>> getTodoListDetails() throws Exception{
        List<TodoItemBean> listTodo = new ArrayList<TodoItemBean>(todoServiceImpl.getAllItem());
        return new ResponseEntity<List<TodoItemBean>>(listTodo, HttpStatus.OK);
    }
}
