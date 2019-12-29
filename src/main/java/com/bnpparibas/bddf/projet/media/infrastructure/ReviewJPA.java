package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Review;
import com.bnpparibas.bddf.projet.media.domain.ReviewNotation;
import com.bnpparibas.bddf.projet.media.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity(name = "REVIEW")
public class ReviewJPA {
    @Id
    @GeneratedValue()
    @Column(name = "ID")
    private Long id;
    @Column(name = "COMMENT")
    @org.hibernate.annotations.Type(type="text")
    private String comment;
    @Column(name = "REVIEW_DATE")
    private LocalDateTime reviewDate;

    @JsonProperty
    @ManyToOne
    @JsonManagedReference
    private MediaJPA mediaJPA;

    @JsonProperty
    @ManyToOne
    private UserJPA userJPA;

    @OneToMany
    @JoinColumn(name="REVIEWJPA_ID")
    @JsonBackReference
    private Set<ReviewNotationJPA> reviewNotationsJPA;

    public ReviewJPA() { }

    public ReviewJPA(Long id, String comment, LocalDateTime reviewDate, MediaJPA mediaJPA, UserJPA userJPA) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.mediaJPA = mediaJPA;
        this.userJPA = userJPA;
    }

    public ReviewJPA(String comment, MediaJPA mediaJPA, UserJPA userJPA) {
        this.comment = comment;
        this.reviewDate = LocalDateTime.now();
        this.mediaJPA = mediaJPA;
        this.userJPA = userJPA;
    }

    public ReviewJPA(Review review) {
        this.id = review.getId();
        this.comment = review.getComment();
        this.reviewDate = review.getReviewDate();
        this.mediaJPA = new MediaJPA (review.getMedia());
        this.userJPA = new UserJPA(review.getUser());
    }

    public Review jpaToReview() {
        Set<ReviewNotation> reviewNotations = null;
        if (this.reviewNotationsJPA != null) {
            reviewNotations = this.reviewNotationsJPA.stream()
                    .map(reviewNotationJPA -> new ReviewNotation(reviewNotationJPA.getNotationId(),
                            null,
                            reviewNotationJPA.isUseful(),
                            new User(reviewNotationJPA.getUserJPA().getId(),
                                    reviewNotationJPA.getUserJPA().getLogin(),
                                    reviewNotationJPA.getUserJPA().isActive())))
                    .collect(Collectors.toSet());
        }
        return new Review(this.id,
                this.comment,
                this.reviewDate,
                null,
                new User(this.userJPA.getId(),
                        this.userJPA.getLogin(),
                        this.userJPA.isActive()),
                reviewNotations);
    }
    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public MediaJPA getMediaJPA() {
        return mediaJPA;
    }

    public UserJPA getUserJPA() {
        return userJPA;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
