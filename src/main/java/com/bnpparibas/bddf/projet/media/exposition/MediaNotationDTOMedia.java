package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.MediaNotation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationDTOMedia {
    //DTO quand le média est connu
    @JsonProperty
    Long id;
    @JsonProperty
    boolean liked;
    @JsonProperty
    String userId;

    public MediaNotationDTOMedia() {
    }

    public MediaNotationDTOMedia(Long id, boolean liked, String userId) {
        this.id = id;
        this.liked = liked;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public boolean isLiked() {
        return liked;
    }

    public String getUserId() {
        return userId;
    }
}
