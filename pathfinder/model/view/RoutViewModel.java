package com.example.pathfinder.model.view;

public class RoutViewModel {

    private Long id;
    private String description;
    private String name;
    private String pictureUrl;

    public RoutViewModel() {
    }

    public Long getId() {
        return id;
    }

    public RoutViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RoutViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoutViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public RoutViewModel setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
