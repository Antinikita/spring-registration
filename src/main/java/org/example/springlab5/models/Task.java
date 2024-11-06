package org.example.springlab5.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "task")
public class Task  {
    private Long task_id;
    private String title;
    private String description;
    private Date due_date;
    private String status;
    private int priority;

    private User user_id;
    private Category category_id;

    public Task() {
    }

    public Task(String title, String description, Date due_date, String status, int priority, User user_id, Category category_id) {
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.status = status;
        this.priority = priority;
        this.user_id = user_id;
        this.category_id = category_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getTask_id() {
        return task_id;
    }
    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }
    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "due_date", nullable = false)
    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "priority", nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
