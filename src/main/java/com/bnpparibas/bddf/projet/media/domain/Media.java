package com.bnpparibas.bddf.projet.media.domain;

import com.bnpparibas.bddf.projet.media.infrastructure.MediaJPA;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;


public class Media {

    private String id;
    private String label;

    private Category category;
    private Type type;

    private String authorName;
    private String authorSurname;

    private String description;
    private String mediaImageURL;
    private LocalDate publicationDate;
    private int likesTotalNumber;
    private int dislikesTotalNumber;
    private Set<MediaNotation> mediaNotations;


    public Media() {}

    public Media(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate, int likesTotalNumber, int dislikesTotalNumber, Set<MediaNotation> mediaNotations) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.description = description;
        this.mediaImageURL = mediaImageURL;
        this.publicationDate = publicationDate;
        this.likesTotalNumber = 0;
        this.dislikesTotalNumber = 0;
        this.mediaNotations = mediaNotations;
    }

    public Media(MediaJPA mediaJPA) {
        this.id = mediaJPA.getId();
        this.label = mediaJPA.getLabel();
        this.category = mediaJPA.getCategory();
        this.type = mediaJPA.getType();
        this.authorName = mediaJPA.getAuthorName();
        this.authorSurname = mediaJPA.getAuthorSurname();
        this.description = mediaJPA.getDescription();
        this.mediaImageURL = mediaJPA.getMediaImageURL();
        this.publicationDate = mediaJPA.getPublicationDate();
        this.mediaNotations = null;
        if (mediaJPA.getMediaNotationsJPA() != null) {
            this.mediaNotations = mediaJPA.getMediaNotationsJPA().stream()
                    .map(mediaNotationJPA -> new MediaNotation(mediaNotationJPA.getNotationId(), this, mediaNotationJPA.isLiked(),
                            new User(mediaNotationJPA.getUserJPA().getId(),
                                    mediaNotationJPA.getUserJPA().getLogin(),
                                    mediaNotationJPA.getUserJPA().getPassword(),
                                    mediaNotationJPA.getUserJPA().getUserName(),
                                    mediaNotationJPA.getUserJPA().getUserSurname(),
                                    mediaNotationJPA.getUserJPA().getAvatarImageURL(),
                                    mediaNotationJPA.getUserJPA().getEmail(),
                                    mediaNotationJPA.getUserJPA().isActive())))
                    .collect(Collectors.toSet());
        }
    }

    public void update(Media mediaToUpdate){
        this.label=mediaToUpdate.getLabel();
        this.category=mediaToUpdate.getCategory();
        this.type=mediaToUpdate.getType();
        this.authorName=mediaToUpdate.getAuthorName();
        this.authorSurname=mediaToUpdate.getAuthorSurname();
        this.description = mediaToUpdate.getDescription();
        this.mediaImageURL = mediaToUpdate.getMediaImageURL();
        this.publicationDate = mediaToUpdate.getPublicationDate();
        this.mediaNotations = mediaToUpdate.getMediaNotations();
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

    public String getDescription() { return description;}

    public String getMediaImageURL() { return mediaImageURL; }

    public LocalDate getPublicationDate() { return publicationDate; }

    public int getLikesTotalNumber() {
        return likesTotalNumber;
    }

    public int getDislikesTotalNumber() {
        return dislikesTotalNumber;
    }

    public Set<MediaNotation> getMediaNotations() {
        return mediaNotations;
    }
}
