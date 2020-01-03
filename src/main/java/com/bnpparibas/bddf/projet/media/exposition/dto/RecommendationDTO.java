package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.bnpparibas.bddf.projet.media.domain.Category;
import com.bnpparibas.bddf.projet.media.domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationDTO {
    @JsonProperty
    long id;

    @JsonProperty
    String mediaLabel;

    @JsonProperty
    Category category;

    @JsonProperty
    Type type;

    @JsonProperty
    int notation;

    public RecommendationDTO(long id, String mediaLabel, Category category, Type type, int notation) {
        this.id = id;
        this.mediaLabel = mediaLabel;
        this.category = category;
        this.type = type;
        this.notation = notation;
    }
}
