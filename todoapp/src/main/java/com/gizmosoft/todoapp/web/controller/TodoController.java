package com.gizmosoft.todoapp.web.controller;

import com.gizmosoft.todoapp.bean.TodoItemBean;
import com.gizmosoft.todoapp.entity.TodoItemEntity;
import com.gizmosoft.todoapp.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
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

   // @PostMapping("/saveItem")
    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public String addNewItem(@ModelAttribute("todoItemBean")TodoItemBean todoItemBean){
//        if(result.hasErrors())
//            return "/addItemForm";
        todoItemBean.setStatus("pending");
        System.out.println(todoItemBean + " in Controller.");
        // save to DB
        todoServiceImpl.addItemsToList(todoItemBean);

        return "redirect:/";
    }

    // Remove Item Functionality
    @RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
    public String removeItem(@ModelAttribute("todoItemBean")TodoItemBean todoItemBean) throws Exception {
        System.out.println(todoItemBean);
        TodoItemBean itemBean = todoServiceImpl.getOneItem(todoItemBean.getId());
        todoServiceImpl.deleteItem(itemBean.getId());
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
}
