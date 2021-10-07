package com.gizmosoft.todoapp.dao;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.entity.TodoItemEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public void addItemsToList(TodoItemBean itemBean){
        TodoItemEntity itemEntityBean = convertBeanToEntity(itemBean);
        try{
            todoDao.save(itemEntityBean);
        }catch (Exception e){
            throw e;
        }
    }

    public static TodoItemBean convertEntityToBean(TodoItemEntity entity) {
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
