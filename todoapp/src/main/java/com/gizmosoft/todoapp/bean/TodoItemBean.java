package com.gizmosoft.todoapp.bean;

public class TodoItemBean {
    private Integer id;
    private String title;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "TodoItemBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
