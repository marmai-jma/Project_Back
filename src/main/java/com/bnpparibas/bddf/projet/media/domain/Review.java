package com.bnpparibas.bddf.projet.media.domain;

import java.time.LocalDateTime;

public class Review {
    private String id;
    private String comment;
    private LocalDateTime reviewDate;
    private int usefulTotalNumber = 0;
    private int uselessTotalNumber = 0;
    private Media media;
    private User user;


    public Review() {}

    public Review(String id, String comment, LocalDateTime reviewDate) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public void update(Review reviewToUpdate) {
        this.comment = reviewToUpdate.getComment();
        this.reviewDate = reviewToUpdate.getReviewDate();
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public int getUsefulTotalNumber() {
        return usefulTotalNumber;
    }

    public int getUselessTotalNumber() {
        return uselessTotalNumber;
    }
}
