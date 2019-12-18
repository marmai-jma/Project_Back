package com.bnpparibas.bddf.projet.media.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ReviewDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;

    @JsonProperty
    String comment;

    @JsonProperty
    LocalDateTime reviewDate;

    @JsonProperty
    int usefulTotalNumber;

    @JsonProperty
    int uselessTotalNumber;

    public ReviewDTO() { }

    public ReviewDTO(String id, String comment, LocalDateTime reviewDate, int usefulTotalNumber, int uselessTotalNumber) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.usefulTotalNumber = usefulTotalNumber;
        this.uselessTotalNumber = uselessTotalNumber;
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

    public int getUsefulTotalNumber() {
        return usefulTotalNumber;
    }

    public int getUselessTotalNumber() {
        return uselessTotalNumber;
    }
}
