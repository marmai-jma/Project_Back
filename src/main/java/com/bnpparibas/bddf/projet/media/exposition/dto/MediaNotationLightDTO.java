package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationLightDTO {
    @JsonProperty
    Long id;
    @JsonProperty
    boolean liked;
    @JsonProperty
    UserLightDTO userDTO;
    @JsonProperty
    MediaLightDTO mediaDTO;

    public MediaNotationLightDTO() {
    }

    public MediaNotationLightDTO(Long id, boolean liked, UserLightDTO userDTO) {
        this.id = id;
        this.liked = liked;
        this.userDTO = userDTO;
    }

    public MediaNotationLightDTO(Long id, boolean liked, UserLightDTO userDTO, MediaLightDTO mediaDTO) {
        this.id = id;
        this.liked = liked;
        this.userDTO = userDTO;
        this.mediaDTO = mediaDTO;
    }

    public Long getId() {
        return id;
    }

    public boolean isLiked() {
        return liked;
    }

    public UserLightDTO getUserDTO() {
        return userDTO;
    }

    public MediaLightDTO getMediaDTO() {
        return mediaDTO;
    }
}
