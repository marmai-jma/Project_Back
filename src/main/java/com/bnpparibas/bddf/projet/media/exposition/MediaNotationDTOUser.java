package com.bnpparibas.bddf.projet.media.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationDTOUser {
    //DTO quand le user est connu
    @JsonProperty
    Long id;
    @JsonProperty
    boolean liked;
    @JsonProperty
    String mediaId;

    public MediaNotationDTOUser() {
    }

    public MediaNotationDTOUser(Long id, boolean liked, String mediaId) {
        this.id = id;
        this.liked = liked;
        this.mediaId = mediaId;
    }

    public Long getId() {
        return id;
    }

    public boolean isLiked() {
        return liked;
    }

    public String getMediaId() {
        return mediaId;
    }
}
