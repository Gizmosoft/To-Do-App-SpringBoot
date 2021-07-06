package com.gizmosoft.todoapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class TodoItemEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String title;
    private int done;

    public TodoItemEntity(){

    }

    public TodoItemEntity(int id, String title, int done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int isDone() {
        return done;
    }

    public void setDone(int done) { this.done = done;
    }
}
