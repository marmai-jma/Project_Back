package com.bnpparibas.bddf.projet.media.domain;

import java.time.LocalDateTime;

public class Review {
    private String id;
    private String comment;
    private LocalDateTime reviewDate;

    public Review() {}

    public Review(String id, String comment, LocalDateTime reviewDate) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
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
}
