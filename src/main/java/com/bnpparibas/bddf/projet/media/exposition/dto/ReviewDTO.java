package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ReviewDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    long id;

    @JsonProperty
    String comment;

    @JsonProperty
    LocalDateTime reviewDate;

    @JsonProperty
    int usefulNumber;

    @JsonProperty
    int uselessNumber;

    @JsonProperty
    UserLightDTO userDto;

    public ReviewDTO() { }

    public ReviewDTO(long id, String comment, LocalDateTime reviewDate, int usefulNumber, int uselessNumber) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.usefulNumber = usefulNumber;
        this.uselessNumber = uselessNumber;
    }

    public ReviewDTO(long id, String comment, LocalDateTime reviewDate, int usefulNumber, int uselessNumber, UserLightDTO userDto) {
        this.id = id;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.usefulNumber = usefulNumber;
        this.uselessNumber = uselessNumber;
        this.userDto = userDto;
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public int getUsefulNumber() {
        return usefulNumber;
    }

    public int getUselessNumber() {
        return uselessNumber;
    }

    public UserLightDTO getUserDto() {
        return userDto;
    }
}
