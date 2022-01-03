package com.example.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private Boolean approved;
    private String textContent;
    private LocalDateTime created;
    private Route route;
    private User author;

    public Comment() {
    }

    @Column(nullable = false)
    public Boolean getApproved() {
        return approved;
    }

    public Comment setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Column(name = "created", nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }
}
