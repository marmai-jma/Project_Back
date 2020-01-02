package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.MediaNotation;
import com.bnpparibas.bddf.projet.media.domain.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name ="MEDIA_NOTATION")
public class MediaNotationJPA {
    @Id
    @Column(name = "NOTATION_ID")
    @GeneratedValue
    private Long notationId;

    @JsonProperty
    @ManyToOne
    @JsonManagedReference
    private MediaJPA mediaJPA;

    @Column(name = "LIKED")
    boolean liked;

    @JsonProperty
    @ManyToOne
    private UserJPA userJPA;

    public MediaNotationJPA() {
    }

    public MediaNotationJPA(Long notationId, MediaJPA mediaJPA, boolean liked, UserJPA userJPA) {
        this.notationId = notationId;
        this.mediaJPA = mediaJPA;
        this.liked = liked;
        this.userJPA = userJPA;
    }

    public MediaNotationJPA(MediaJPA mediaJPA, boolean liked, UserJPA userJPA) {
        this.mediaJPA = mediaJPA;
        this.liked = liked;
        this.userJPA = userJPA;
    }
    public MediaJPA getMediaJPA() {
        return mediaJPA;
    }

    public boolean isLiked() {
        return liked;
    }

    public UserJPA getUserJPA() {
        return userJPA;
    }

    public Long getNotationId() {
        return notationId;
    }

    public MediaNotation jpaToMediaNotation() {
        return new MediaNotation(this.notationId,
                new Media( this.mediaJPA.getId(),
                        this.mediaJPA.getLabel(),
                        this.mediaJPA.getCategory(),
                        this.mediaJPA.getType(),
                        this.mediaJPA.getAuthorName(),
                        this.mediaJPA.getAuthorSurname(),
                        this.mediaJPA.getDescription(),
                        this.mediaJPA.getMediaImageURL(),
                        this.mediaJPA.getPublicationDate(),
                        null,
                        null),
                this.liked,
                new User(this.userJPA.getId(),
                        this.userJPA.getLogin(),
                        this.userJPA.isActive()));
    }
}
