package com.bnpparibas.bddf.projet.media.infrastructure;

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
}
