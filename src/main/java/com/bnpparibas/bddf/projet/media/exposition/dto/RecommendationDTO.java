package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationDTO {
    @JsonProperty
    long id;

    @JsonProperty
    MediaLightDTO mediaLightDTO;

    @JsonProperty
    int notation;

    public RecommendationDTO(long id, MediaLightDTO mediaLightDTO, int notation) {
        this.id = id;
        this.mediaLightDTO = mediaLightDTO;
        this.notation = notation;
    }
}
