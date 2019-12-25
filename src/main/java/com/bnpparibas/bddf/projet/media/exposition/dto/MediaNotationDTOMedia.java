package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationDTOMedia {
    @JsonProperty
    Long id;
    @JsonProperty
    boolean liked;
    @JsonProperty
    MediaDTO mediaDTO;

    public MediaNotationDTOMedia() {
    }

    public MediaNotationDTOMedia(Long id, boolean liked, MediaDTO mediaDTO) {
        this.id = id;
        this.liked = liked;
        this.mediaDTO = mediaDTO;
    }

    public Long getId() {
        return id;
    }

    public boolean isLiked() {
        return liked;
    }

    public MediaDTO getMediaDTO() {
        return mediaDTO;
    }
}
