package com.gizmosoft.todoapp.service;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.entity.TodoItemEntity;

import java.util.Collection;

public interface TodoService {

    Collection<TodoItemBean> getAllItem();

    public void addItemsToList(TodoItemBean todoItemBean);

    public TodoItemBean getOneItem(Integer id) throws Exception;

    public void deleteItem(Integer id);
}
