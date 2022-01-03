package com.example.pathfinder.model.view;

import java.time.LocalDateTime;

public class CommentViewModel {

    private Long id;
    private String message;
    private String user;
    private LocalDateTime created;
    private boolean canApprove;
    private boolean canDelete;


    public CommentViewModel() {
    }

    public Long getCommentId() {
        return id;
    }

    public CommentViewModel setCommentId(Long commentId) {
        this.id = commentId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommentViewModel setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUser() {
        return user;
    }

    public CommentViewModel setUser(String user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public boolean isCanApprove() {
        return canApprove;
    }

    public CommentViewModel setCanApprove(boolean canApprove) {
        this.canApprove = canApprove;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public CommentViewModel setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }
}
