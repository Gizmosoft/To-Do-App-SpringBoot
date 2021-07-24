package com.gizmosoft.todoapp.service;

import com.gizmosoft.todoapp.bean.TodoItemBean;

import java.util.Collection;

public interface TodoService {

    Collection<TodoItemBean> getAllItem();
    Collection<Integer> getStatus();
}
