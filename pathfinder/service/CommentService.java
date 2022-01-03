package com.example.pathfinder.service;

import com.example.pathfinder.model.service.CommentServiceModel;
import com.example.pathfinder.model.view.CommentViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

public interface CommentService {

    List<CommentViewModel> getComments(Long routeId);

    CommentViewModel createComment(CommentServiceModel commentServiceModel);
}
