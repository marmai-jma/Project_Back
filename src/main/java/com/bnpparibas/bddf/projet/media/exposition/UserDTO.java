package com.bnpparibas.bddf.projet.media.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;

    @JsonProperty
    String login;

    @JsonProperty
    String password;

    @JsonProperty
    String userName;

    @JsonProperty
    String userSurname;

    @JsonProperty
    String avatarImageURL;

    @JsonProperty
    String email;

    public UserDTO() {}

    public UserDTO(String id, String login, String password, String userName, String userSurname, String avatarImageURL, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.userSurname = userSurname;
        this.avatarImageURL = avatarImageURL;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getAvatarImageURL() {
        return avatarImageURL;
    }

    public String getEmail() {
        return email;
    }
}
