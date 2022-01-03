package com.example.pathfinder.service.Impl;

import com.example.pathfinder.model.service.CommentServiceModel;
import com.example.pathfinder.repository.CommentRepository;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.exceptions.ObjectNotFoundException;
import com.example.pathfinder.model.entity.Comment;
import com.example.pathfinder.model.view.CommentViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(RouteRepository routeRepository, CommentRepository commentRepository, UserRepository userRepository) {

        this.routeRepository = routeRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<CommentViewModel> getComments(Long routeId) {
        var routeOpt =
                routeRepository.findById(routeId);


        if (routeOpt.isEmpty()) {
            throw new ObjectNotFoundException("route whit id" + routeId + " not found!");
        }
        return routeOpt.get().getComments()
                .stream()
                .map(this::asComment).collect(Collectors.toList());
    }

    @Override
    public CommentViewModel createComment(CommentServiceModel commentServiceModel) {

        Objects.requireNonNull(commentServiceModel.getCreator());

        var route = routeRepository.
                findById(commentServiceModel.getRouteId()).
                orElseThrow(() -> new ObjectNotFoundException("Route with id " + commentServiceModel.getRouteId() + " not found!"));

        var author = userRepository.
                findByEmail(commentServiceModel.getCreator()).
                orElseThrow(() -> new ObjectNotFoundException("User with eamil " + commentServiceModel.getCreator() + " not found!"));

        Comment newComment = new Comment();
        newComment.setApproved(false);
        newComment.setTextContent(commentServiceModel.getMessage());
        newComment.setCreated(LocalDateTime.now());
        newComment.setRoute(route);
        newComment.setAuthor(author);

        Comment savedComment = commentRepository.save(newComment);

        return asComment(savedComment);
    }

    private CommentViewModel asComment(Comment commentEntity) {

        CommentViewModel commentViewModel = new CommentViewModel();

        commentViewModel
                .setCommentId(commentEntity.getId())
                .setCanApprove(true)
                .setCanDelete(true)
                .setCreated(commentEntity.getCreated())
                .setMessage(commentEntity.getTextContent())
                .setUser(commentEntity.getAuthor().getFullName());

        return commentViewModel;

    }
}
