package com.example.pathfinder.service.Impl;

import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RoutViewModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CategoryService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository,
                            CategoryService categoryService, UserService userService, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public List<RoutViewModel> findAllRoutesViewModels() {
        return routeRepository.findAll()
                .stream()
                .map(route -> {
                    RoutViewModel routViewModel = modelMapper.map(route, RoutViewModel.class);
                    if (route.getPictures().isEmpty()) {
                        routViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routViewModel.setPictureUrl(route
                                .getPictures()
                                .stream()
                                .findFirst().get().getUrl());
                    }
                    return routViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = modelMapper.map(routeServiceModel, Route.class);
        //TODO:
        // route.setAuthor(userService.findCurrentLoginUser());

        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toList()));

        routeRepository.save(route);
    }

    @Transactional
    @Override
    public RouteDetailsViewModel findRouteById(Long id) {

        return routeRepository.findById(id)
                .map(route -> modelMapper.map(route, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
