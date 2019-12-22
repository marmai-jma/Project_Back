package com.bnpparibas.bddf.projet.media.domain;

public class MediaNotation {
    private Long id;
    private Media media;
    private boolean liked;
    private User user;

    public MediaNotation() {
    }

    public MediaNotation(Long id, Media media, boolean liked, User user) {
        this.id = id;
        this.media = media;
        this.liked = liked;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Media getMedia() {
        return media;
    }

    public boolean isLiked() {
        return liked;
    }

    public User getUser() {
        return user;
    }
}
