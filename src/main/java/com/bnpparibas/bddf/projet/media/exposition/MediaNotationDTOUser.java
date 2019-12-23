package com.bnpparibas.bddf.projet.media.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaNotationDTOUser {
    @JsonProperty
    Long id;
    @JsonProperty
    boolean liked;
    @JsonProperty
    UserDTO userDTO;

    public MediaNotationDTOUser() {
    }

    public MediaNotationDTOUser(Long id, boolean liked, UserDTO userDTO) {
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

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
