package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class UserLightDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;

    @JsonProperty
    String login;

    public UserLightDTO() {}

    public UserLightDTO(String id, String login) {
        this.id = id;
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

}
