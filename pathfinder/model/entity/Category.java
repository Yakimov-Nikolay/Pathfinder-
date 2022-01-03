package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.CategoryNameEnums;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String description;
    private CategoryNameEnums name;

    public Category() {
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnums getName() {
        return name;
    }

    public Category setName(CategoryNameEnums name) {
        this.name = name;
        return this;
    }
}
