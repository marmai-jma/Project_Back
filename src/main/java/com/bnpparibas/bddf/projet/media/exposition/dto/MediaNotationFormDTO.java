package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationFormDTO {

    @JsonProperty
    boolean liked;

    public MediaNotationFormDTO() {
    }

    public MediaNotationFormDTO(boolean liked) {
        this.liked = liked;
    }

    public boolean isLiked() {
        return liked;
    }
}
