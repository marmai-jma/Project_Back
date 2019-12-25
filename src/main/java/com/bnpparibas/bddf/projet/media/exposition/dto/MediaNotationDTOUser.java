package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationDTOUser {
    @JsonProperty
    Long id;
    @JsonProperty
    boolean liked;
    @JsonProperty
    UserLightDTO userDTO;

    public MediaNotationDTOUser() {
    }

    public MediaNotationDTOUser(Long id, boolean liked, UserLightDTO userDTO) {
        this.id = id;
        this.liked = liked;
        this.userDTO = userDTO;
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
}
