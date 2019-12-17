package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USER")
public class UserJPA {
    @Id
    //@GeneratedValue()
    @Column(name = "ID")
    private String id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_SURNAME")
    private String userSurname;

    @Column(name = "AVATAR_IMAGE_URL")
    private String avatarImageURL;

    @Column(name = "EMAIL")
    private String email;

    public UserJPA() { }

    public UserJPA(String id, String login, String password, String userName, String userSurname, String avatarImageURL, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.userSurname = userSurname;
        this.avatarImageURL = avatarImageURL;
        this.email = email;
    }

    public UserJPA(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        this.userSurname = user.getUserSurname();
        this.avatarImageURL=user.getAvatarImageURL();
        this.email=user.getEmail();
    }

    public User toUser(){
        return new User(this.id,
                this.login,
                this.password,
                this.userName,
                this.userSurname,
                this.avatarImageURL,
                this.email);
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
}
