package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.RouteAddBindingModel;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    private String allRoutes(Model model) {
        routeService.findAllRoutesViewModels();
        model.addAttribute("routes", routeService.findAllRoutesViewModels());

        return "routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        model.addAttribute("route", routeService.findRouteById(id));

        return "route-details";
    }

    @GetMapping("/add")
    public String add() {

        return "add-route";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("roadAddBindingModel", redirectAttributes);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roadAddBindingModel", bindingResult);

            return "redirect:add";
        }

        RouteServiceModel routeServiceModel =
                modelMapper.map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel
                .setGpxCoordinates(new String(routeAddBindingModel.getGpsCoordinates().getBytes()));

        routeService.addNewRoute(routeServiceModel);

        return "redirect:all";
    }


    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }

}


