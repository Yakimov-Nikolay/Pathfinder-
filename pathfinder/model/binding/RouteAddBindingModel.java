package com.example.pathfinder.model.binding;

import com.example.pathfinder.model.entity.enums.CategoryNameEnums;
import com.example.pathfinder.model.entity.enums.LevelEnums;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class RouteAddBindingModel {

    private String name;
    private String description;
    private MultipartFile gpsCoordinates;
    private LevelEnums level;
    private String videoUrl;
    private Set<CategoryNameEnums> category;

    public RouteAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Route must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public RouteAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3)
    public String getDescription() {
        return description;
    }

    public RouteAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpsCoordinates() {
        return gpsCoordinates;
    }

    public RouteAddBindingModel setGpsCoordinates(MultipartFile gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
        return this;
    }

    @NotNull
    public LevelEnums getLevel() {
        return level;
    }

    public RouteAddBindingModel setLevel(LevelEnums level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteAddBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNameEnums> getCategory() {
        return category;
    }

    public RouteAddBindingModel setCategory(Set<CategoryNameEnums> category) {
        this.category = category;
        return this;
    }
}
