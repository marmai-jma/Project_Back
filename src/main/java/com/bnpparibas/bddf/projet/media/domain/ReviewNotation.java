package com.bnpparibas.bddf.projet.media.domain;

public class ReviewNotation {
    private Long id;
    private Review review;
    private boolean useful;
    private User user;

    public ReviewNotation() {
    }

    public ReviewNotation(Long id, Review review, boolean useful, User user) {
        this.id = id;
        this.review = review;
        this.useful = useful;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Review getReview() {
        return review;
    }

    public boolean isUseful() {
        return useful;
    }

    public User getUser() {
        return user;
    }
}
