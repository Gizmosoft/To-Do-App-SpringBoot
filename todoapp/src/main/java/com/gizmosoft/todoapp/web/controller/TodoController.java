package com.gizmosoft.todoapp.web.controller;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    // Gets list - not being used in the project currently
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseEntity<List<TodoItemBean>> getTodoListDetails() throws Exception{
        List<TodoItemBean> listTodo = new ArrayList<TodoItemBean>(todoServiceImpl.getAllItem());
        return new ResponseEntity<List<TodoItemBean>>(listTodo, HttpStatus.OK);
    }

    // Below function redirects to the form.html page to add items to the list
    @RequestMapping(value = "/addItemForm")
    public ModelAndView showAddPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form.html");
        return modelAndView;
    }

    @PostMapping("/addItemForm")
    public String saveItem(@ModelAttribute TodoItemBean todoItemBean, Model model){
        // save added item to the DB
        System.out.println(todoItemBean.getTitle() + " " + todoItemBean.getTitle());
        model.addAttribute("todoItemBean", todoItemBean);
        todoServiceImpl.addItemsToList(todoItemBean);
        return "redirect:/";
    }

    // The below function shows the to-do list and provides a button to add new items to the list
    @RequestMapping(value = "/")
    public ModelAndView home(){
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
