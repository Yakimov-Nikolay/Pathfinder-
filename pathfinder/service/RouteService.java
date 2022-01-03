package com.example.pathfinder.service;

import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RoutViewModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;

import java.util.List;

public interface RouteService {
    List<RoutViewModel> findAllRoutesViewModels();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);
}
