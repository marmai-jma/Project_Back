package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "REVIEW")
public class ReviewJPA {
    @Id
    //@GeneratedValue()
    @Column(name = "ID")
    private String id;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "REVIEW_DATE")
    private LocalDateTime reviewDate;

    public ReviewJPA() { }

    public ReviewJPA(String id, String comment, LocalDateTime reviewDate) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public ReviewJPA(Review review) {
        this.id = review.getId();
        this.comment = review.getComment();
        this.reviewDate = review.getReviewDate();
    }

    public Review toReview() {
        return new Review(this.id,
                this.comment,
                this.reviewDate);
    }


    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }
}
