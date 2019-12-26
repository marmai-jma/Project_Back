package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.MediaNotation;
import com.bnpparibas.bddf.projet.media.domain.User;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "USER")
public class UserJPA {
    @Id
    @GeneratedValue()
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN", unique = true)
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

    @Column(name = "ACTIVE")
    private boolean active;

    @OneToMany
    @JoinColumn(name="USERJPA_ID")
    private Set<MediaNotationJPA> mediaNotationsJPA;

    public UserJPA() { }

    public UserJPA(Long id, String login, String password, String userName, String userSurname, String avatarImageURL, String email, boolean active) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.userSurname = userSurname;
        this.avatarImageURL = avatarImageURL;
        this.email = email;
        this.active = active;
    }

    public UserJPA(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        this.userSurname = user.getUserSurname();
        this.avatarImageURL=user.getAvatarImageURL();
        this.email=user.getEmail();
        this.active=user.isActive();
    }

    public UserJPA(User user, Set<MediaNotationJPA> mediaNotationJPAS) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        this.userSurname = user.getUserSurname();
        this.avatarImageURL=user.getAvatarImageURL();
        this.email=user.getEmail();
        this.active=user.isActive();
        this.mediaNotationsJPA = mediaNotationJPAS;
    }

    public User jpatoUser(){
        Set<MediaNotation> mediaNotations = null;

        if (this.getMediaNotationsJPA() != null) {
            mediaNotations = this.getMediaNotationsJPA().stream()
                    .map(mediaNotationJPA -> new MediaNotation(mediaNotationJPA.getNotationId(),
                            new Media(mediaNotationJPA.getMediaJPA().getId(),
                                    mediaNotationJPA.getMediaJPA().getLabel(),
                                    mediaNotationJPA.getMediaJPA().getCategory(),
                                    mediaNotationJPA.getMediaJPA().getType(),
                                    mediaNotationJPA.getMediaJPA().getAuthorName(),
                                    mediaNotationJPA.getMediaJPA().getAuthorSurname(),
                                    mediaNotationJPA.getMediaJPA().getDescription(),
                                    mediaNotationJPA.getMediaJPA().getMediaImageURL(),
                                    mediaNotationJPA.getMediaJPA().getPublicationDate(),
                                    null, null),
                            mediaNotationJPA.isLiked(), null))
                    .collect(Collectors.toSet());
        }
        return new User(this.getId(),
                this.getLogin(),
                this.getPassword(),
                this.getUserName(),
                this.getUserSurname(),
                this.getAvatarImageURL(),
                this.getEmail(),
                this.isActive(),
                mediaNotations);



    }

    public Long getId() {
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

    public Set<MediaNotationJPA> getMediaNotationsJPA() {
        return mediaNotationsJPA;
    }
}
