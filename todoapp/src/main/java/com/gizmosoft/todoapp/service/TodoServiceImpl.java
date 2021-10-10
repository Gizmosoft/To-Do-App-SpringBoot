package com.gizmosoft.todoapp.service;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.dao.TodoDaoWrapper;
import com.gizmosoft.todoapp.entity.TodoItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoDaoWrapper todoDaoWrapper;

    public Collection<TodoItemBean> getAllItem(){
        return todoDaoWrapper.findAll();
    }

    public void addItemsToList(TodoItemBean todoItemBean){
        System.out.println(todoItemBean.getTitle() + " in Service.");
        todoDaoWrapper.addItemsToList(todoItemBean);
    }
}
