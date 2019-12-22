package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.MediaNotation;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name ="MEDIA_NOTATION")
public class MediaNotationJPA {
    @Id
    @GeneratedValue
    Long id;

    @JsonProperty
    @ManyToOne
    MediaJPA mediaJPA;

    @Column(name = "LIKED")
    boolean liked;

    @Column
    String userJPA; // A revoir

    public MediaNotationJPA() {
    }

    public MediaNotationJPA(Long id, MediaJPA mediaJPA, boolean liked, String userJPA) {
        this.id = id;
        this.mediaJPA = mediaJPA;
        this.liked = liked;
        this.userJPA = userJPA;
    }

    public MediaNotationJPA(MediaNotation mediaNotation) {
        this.id = mediaNotation.getId();
        this.mediaJPA = new MediaJPA(mediaNotation.getMedia());
        this.liked = mediaNotation.isLiked();
        this.userJPA = "userJPA";
    }

    public MediaJPA getMediaJPA() {
        return mediaJPA;
    }

    public boolean isLiked() {
        return liked;
    }

    public String getUserJPA() {
        return userJPA;
    }

    public Long getId() {
        return id;
    }
}
