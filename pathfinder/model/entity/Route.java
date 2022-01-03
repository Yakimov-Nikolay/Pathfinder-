package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnums;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    private String description;
    private String gpxCoordinates;
    private LevelEnums level;
    private String name;
    private User author;
    private List<Picture> pictures;
    private String videoUrl;
    private List<Category> categories;
    private List<Comment> comments;


    public Route() {
    }

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    public List<Comment> getComments() {
        return comments;
    }

    public Route setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    public List<Category> getCategories() {
        return categories;
    }

    public Route setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    public List<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(columnDefinition = "LONGTEXT")
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public LevelEnums getLevel() {
        return level;
    }

    public Route setLevel(LevelEnums level) {
        this.level = level;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    @Column
    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
