package org.example.springlab5.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "categories")
public class Category  {
    private Long category_id;
    private String category_name;

    public Category() {
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getCategory_id() {
        return category_id;
    }
    public void setCategory_id(Long category_id) {

        this.category_id = category_id;
    }
    @Column(name = "category_name",nullable = false)
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
