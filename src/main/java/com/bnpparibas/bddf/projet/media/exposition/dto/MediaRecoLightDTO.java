package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.bnpparibas.bddf.projet.media.domain.Category;
import com.bnpparibas.bddf.projet.media.domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaRecoLightDTO {
    @JsonProperty
    long numReco;

    @JsonProperty
    String mediaLabel;

    @JsonProperty
    Category category;

    @JsonProperty
    Type type;

    @JsonProperty
    int notation;

    public MediaRecoLightDTO(long numReco, String mediaLabel, Category category, Type type, int notation) {
        this.numReco = numReco;
        this.mediaLabel = mediaLabel;
        this.category = category;
        this.type = type;
        this.notation = notation;
    }

    public long getNumReco() {
        return numReco;
    }

    public void setNumReco(long numReco) {
        this.numReco = numReco;
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
}
