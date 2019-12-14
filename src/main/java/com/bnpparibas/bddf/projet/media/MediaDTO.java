package com.bnpparibas.bddf.projet.media;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String id;

    @JsonProperty
    String label;

    @JsonProperty
    Category category;

    @JsonProperty
    Type type;

    @JsonProperty
    String authorName;

    @JsonProperty
    String authorSurname;

    public MediaDTO() {}

    public MediaDTO(String id, String label, Category category, Type type, String authorName, String authorSurname) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }
}
