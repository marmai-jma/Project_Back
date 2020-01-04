package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.bnpparibas.bddf.projet.media.domain.Category;
import com.bnpparibas.bddf.projet.media.domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaRecoLightDTO {
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

    @JsonProperty
    int weightedNotation;

    @JsonProperty
    String mediaId;

    @JsonProperty
    String mediaImageURL;


    public MediaRecoLightDTO(long id, String mediaLabel, Category category, Type type, int notation, int weightedNotation, String mediaId, String mediaImageURL) {
        this.id = id;
        this.mediaLabel = mediaLabel;
        this.category = category;
        this.type = type;
        this.notation = notation;
        this.weightedNotation = weightedNotation;
        this.mediaId = mediaId;
        this.mediaImageURL = mediaImageURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMediaLabel() {
        return mediaLabel;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public int getNotation() {
        return notation;
    }

    public int getWeightedNotation() {
        return weightedNotation;
    }
}
