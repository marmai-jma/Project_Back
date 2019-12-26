package com.bnpparibas.bddf.projet.media.infrastructure;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name ="REVIEW_NOTATION")
public class ReviewNotationJPA {
    @Id
    @Column(name = "NOTATION_ID")
    @GeneratedValue
    private Long notationId;

    @JsonProperty
    @ManyToOne
    @JsonManagedReference
    private ReviewJPA reviewJPA;

    @Column(name = "USEFUL")
    boolean useful;

    @JsonProperty
    @ManyToOne
    private UserJPA userJPA;

    public ReviewNotationJPA() {
    }

    public ReviewNotationJPA(Long notationId, ReviewJPA reviewJPA, boolean useful, UserJPA userJPA) {
        this.notationId = notationId;
        this.reviewJPA = reviewJPA;
        this.useful = useful;
        this.userJPA = userJPA;
    }

    public ReviewNotationJPA(ReviewJPA reviewJPA, boolean useful, UserJPA userJPA) {
        this.reviewJPA = reviewJPA;
        this.useful = useful;
        this.userJPA = userJPA;
    }

    public Long getNotationId() {
        return notationId;
    }

    public ReviewJPA getReviewJPA() {
        return reviewJPA;
    }

    public boolean isUseful() {
        return useful;
    }

    public UserJPA getUserJPA() {
        return userJPA;
    }
}
