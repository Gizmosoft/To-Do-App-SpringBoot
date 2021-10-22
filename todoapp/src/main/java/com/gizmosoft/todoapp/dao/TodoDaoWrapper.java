package com.gizmosoft.todoapp.dao;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.entity.TodoItemEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoDaoWrapper{

    @Autowired
    private TodoDao todoDao;

    public List<TodoItemBean> findAll(){
        List<TodoItemBean> todolist = null;

        try {
            todolist = new ArrayList<TodoItemBean>();

            Iterable<TodoItemEntity> todolistEn = todoDao.findAll();
            for (TodoItemEntity todoentity : todolistEn) {
                TodoItemBean todobean = new TodoItemBean();
                todobean = convertEntityToBean(todoentity);
                todolist.add(todobean);
            }
        }catch (Exception e){
            throw e;
        }
        return todolist;
    }

    public void addItemsToList(TodoItemBean todoItemBean){
        System.out.println(todoItemBean.getTitle() + " in DAO.");
        TodoItemEntity todoItemEntity = convertBeanToEntity(todoItemBean);
        try{
            System.out.println(todoItemEntity.getTitle() + " in DAO - After conversion to entity.");
            todoDao.saveAndFlush(todoItemEntity);
            System.out.println(todoItemEntity.getTitle() + " " + todoItemEntity.getId() + " in DAO - After adding to Db.");
        }catch (Exception e){
            throw e;
        }
    }

    public TodoItemBean getOneItem(Integer id){
        TodoItemBean todoItemBean = null;

        try{
            Optional<TodoItemEntity> todoItemEntity = todoDao.findById(id);
            if (todoItemEntity!= null){
                todoItemBean = convertEntityToBean2(todoItemEntity);
            }
        }catch (Exception e){
            throw e;
        }
        return todoItemBean;
    }

    // delete functionality
    public void deleteItem(Integer id){
        TodoItemEntity todoItemEntity = todoDao.getById(id);
        System.out.println(todoItemEntity.getId() + " is being deleted.");
        todoDao.delete(todoItemEntity);
    }

    // Conversion Methods
    public static TodoItemBean convertEntityToBean(TodoItemEntity entity) {
        TodoItemBean bean = new TodoItemBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public static TodoItemBean convertEntityToBean2(Optional<TodoItemEntity> entity) {
        TodoItemBean bean = new TodoItemBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public static TodoItemEntity convertBeanToEntity(TodoItemBean bean) {
        TodoItemEntity entity = new TodoItemEntity();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }
}
