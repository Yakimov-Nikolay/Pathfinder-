package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.Picture;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelEnums;

import java.util.Set;

public class RouteDetailsViewModel {

    private Long id;
    private String description;
    private String gpxCoordinates;
    private LevelEnums level;
    private String name;
    private Set<Picture> pictures;
    private String videoUrl;

    public RouteDetailsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteDetailsViewModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnums getLevel() {
        return level;
    }

    public RouteDetailsViewModel setLevel(LevelEnums level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteDetailsViewModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
