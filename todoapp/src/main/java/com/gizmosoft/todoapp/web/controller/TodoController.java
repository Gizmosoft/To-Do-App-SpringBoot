package com.gizmosoft.todoapp.web.controller;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseEntity<List<TodoItemBean>> getTodoListDetails() throws Exception{
        List<TodoItemBean> listTodo = new ArrayList<TodoItemBean>(todoServiceImpl.getAllItem());
        return new ResponseEntity<List<TodoItemBean>>(listTodo, HttpStatus.OK);
    }

    @RequestMapping(value = "/addPage")
    public ModelAndView showAddPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form.html");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView addItems(@RequestParam("itemObj") TodoItemBean itemBean){
        ModelAndView modelAndView = new ModelAndView();
        todoServiceImpl.addItemsToList(itemBean);
        modelAndView.setViewName("index.html");
        modelAndView.addObject("itemObj", new TodoItemBean());
        return modelAndView;
    }

    @RequestMapping(value = "/")
    public ModelAndView listOfTodo(){
        ModelAndView modelAndView = new ModelAndView();
        List<TodoItemBean> listTodo = new ArrayList<TodoItemBean>(todoServiceImpl.getAllItem());
        modelAndView.addObject("list",listTodo);
        modelAndView.setViewName("index.html");
        return modelAndView;
    }



//    @RequestMapping(value="/")
//    public ModelAndView getIndex() {
//        System.out.println("Looking in the index controller.........");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index.html");
//        return modelAndView;
//    }

}
