package com.bnpparibas.bddf.projet.media.domain;

public class User {
    private String id;
    private String login;
    private String password;
    private String userName;
    private String userSurname;
    private String avatarImageURL;
    private String email;
    private boolean active;

    public User() {}

    public User(String id, String login, String password, String userName, String userSurname, String avatarImageURL, String email, boolean active) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.userSurname = userSurname;
        this.avatarImageURL = avatarImageURL;
        this.email = email;
        this.active = active;
    }

    public void update(User userToUpdate){
        this.password=userToUpdate.getPassword();
        this.userName=userToUpdate.getUserName();
        this.userSurname=userToUpdate.getUserSurname();
        this.avatarImageURL=userToUpdate.getAvatarImageURL();
        this.email=userToUpdate.getEmail();
        this.active=userToUpdate.isActive();
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

    public boolean isActive() {
        return active;
    }
}
