package com.gizmosoft.todoapp.dao;

import com.gizmosoft.todoapp.entity.TodoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<TodoItemEntity, Integer> {

}
