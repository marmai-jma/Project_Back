package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class UserLightDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;

    @JsonProperty
    String login;

    @JsonProperty
    boolean active;

    public UserLightDTO() {}

    public UserLightDTO(String id, String login, boolean active) {
        this.id = id;
        this.login = login;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public boolean isActive() {
        return active;
    }
}
