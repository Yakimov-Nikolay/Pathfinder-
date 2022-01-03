package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.entity.enums.CategoryNameEnums;

public interface CategoryService {
    Category findCategoryByName(CategoryNameEnums categoryNameEnums);
}
