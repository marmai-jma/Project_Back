package com.bnpparibas.bddf.projet.media.domain;

import java.time.LocalDateTime;

public class Review {
    private long id;
    private String comment;
    private LocalDateTime reviewDate;
    private Media media;
    private User user;


    public Review() {}

    public Review(long id, String comment, LocalDateTime reviewDate, Media media, User user) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.media = media;
        this.user = user;
    }

    public void update(Review reviewToUpdate) {
        this.comment = reviewToUpdate.getComment();
        this.reviewDate = reviewToUpdate.getReviewDate();
        this.media = reviewToUpdate.getMedia();
        this.user = reviewToUpdate.getUser();
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public Media getMedia() {
        return media;
    }

    public User getUser() {
        return user;
    }

    public int getUsefulNumber() {
        return 0;
    }

    public int getUselessNumber() {
        return 0;
    }
}
