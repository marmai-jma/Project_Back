package com.bnpparibas.bddf.projet.media.exposition.dto;

import com.bnpparibas.bddf.projet.media.domain.Category;
import com.bnpparibas.bddf.projet.media.domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Set;

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

    @JsonProperty
    String description;
    @JsonProperty
    String mediaImageURL;
    @JsonProperty
    LocalDate publicationDate;

    @JsonProperty
    int likesNumber;

    @JsonProperty
    int dislikesNumber;

    @JsonProperty
    Set<MediaNotationDTOUser> mediaNotationsDTO;

    @JsonProperty
    Set<ReviewDTO> ReviewDTO;

    public MediaDTO() {}

    public MediaDTO(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate, int likesNumber, int dislikesNumber, Set<MediaNotationDTOUser> mediaNotationsDTO, Set<com.bnpparibas.bddf.projet.media.exposition.dto.ReviewDTO> reviewDTO) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.description = description;
        this.mediaImageURL = mediaImageURL;
        this.publicationDate = publicationDate;
        this.likesNumber = likesNumber;
        this.dislikesNumber = dislikesNumber;
        this.mediaNotationsDTO = mediaNotationsDTO;
        ReviewDTO = reviewDTO;
    }

    public MediaDTO(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate, int likesTotalNumber, int dislikesTotalNumber) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.description = description;
        this.mediaImageURL = mediaImageURL;
        this.publicationDate = publicationDate;
        this.likesNumber = likesTotalNumber;
        this.dislikesNumber = dislikesTotalNumber;
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

    public String getDescription() { return description; }

    public String getMediaImageURL() { return mediaImageURL; }

    public LocalDate getPublicationDate() { return publicationDate; }

    public int getLikesNumber() {
        return likesNumber;
    }

    public int getDislikesNumber() {
        return dislikesNumber;
    }

    public Set<MediaNotationDTOUser> getMediaNotationsDTO() {
        return mediaNotationsDTO;
    }
}
