package com.bnpparibas.bddf.projet.media.domain;

import java.time.LocalDateTime;

public class Review {
    private String id;
    private String comment;
    private LocalDateTime reviewDate;
    private Media media;
    private User user;


    public Review() {}

    public Review(String id, String comment, LocalDateTime reviewDate, Media media, User user) {
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

    public String getId() {
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

    //ici ajouter getter pour récupérer le nombre de usefull et le nombre de votes total quand la table des reviewNotations sera implémentée.
}
