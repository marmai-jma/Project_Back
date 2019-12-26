package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewNotationFormDTO {

    @JsonProperty
    boolean useful;

    public ReviewNotationFormDTO() {
    }

    public ReviewNotationFormDTO(boolean useful) {
        this.useful = useful;
    }

    public boolean isUseful() {
        return useful;
    }
}
