package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.NewCommentBindingModel;
import com.example.pathfinder.model.service.CommentServiceModel;
import com.example.pathfinder.model.validation.ApiErrors;
import com.example.pathfinder.model.view.CommentViewModel;
import com.example.pathfinder.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.*;

@RestController
public class CommentsRestController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentsRestController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/{routeId}/comments")
    public ResponseEntity<List<CommentViewModel>> getComments(
            @PathVariable Long routeId, Principal principal) {
        return ResponseEntity.ok(commentService.getComments(routeId));
    }

    @PostMapping("/api/{routeId}/comments")
    public ResponseEntity<CommentViewModel> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long routeId,
            @RequestBody @Valid NewCommentBindingModel newCommentBindingModel
    ) {
        CommentServiceModel serviceModel =
                modelMapper.map(newCommentBindingModel, CommentServiceModel.class);
        serviceModel.setCreator(principal.getUsername());
        serviceModel.setRouteId(routeId);

        CommentViewModel newComment =
                commentService.createComment(serviceModel);

        URI locationOfNewComment =
                URI.create(String.format("/api/%s/comments/%s", routeId, newComment.getCommentId()));

        return ResponseEntity.
                created(locationOfNewComment).
                body(newComment);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrors> onValidationFailure(MethodArgumentNotValidException exception) {
        ApiErrors apiError = new ApiErrors(HttpStatus.BAD_REQUEST);
        exception.getFieldErrors()
                .forEach(fe ->
                        apiError.addFieldWhitError(fe.getField())
                );

        return ResponseEntity
                .badRequest()
                .body(apiError);

    }
}
