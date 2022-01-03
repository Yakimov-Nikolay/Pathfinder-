package com.example.pathfinder.model.service;

import com.example.pathfinder.model.entity.Picture;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.CategoryNameEnums;
import com.example.pathfinder.model.entity.enums.LevelEnums;

import java.util.Set;

public class RouteServiceModel extends BaseServiceModel {

    private String description;
    private String gpxCoordinates;
    private LevelEnums level;
    private String name;
    private User author;
    private Set<Picture> pictures;
    private String videoUrl;
    private Set<CategoryNameEnums> categories;

    public RouteServiceModel() {
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnums getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelEnums level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<CategoryNameEnums> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<CategoryNameEnums> categories) {
        this.categories = categories;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

}
