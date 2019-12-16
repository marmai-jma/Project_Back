package com.bnpparibas.bddf.projet.media;

import java.time.LocalDate;


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

    public Media() {}

    public Media(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.description = description;
        this.mediaImageURL = mediaImageURL;
        this.publicationDate = publicationDate;
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
}
