package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewFormDTO {
    @JsonProperty
    String comment;

    public ReviewFormDTO() { }

    public ReviewFormDTO(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
