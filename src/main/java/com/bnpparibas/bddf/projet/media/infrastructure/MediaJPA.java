package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Category;
import com.bnpparibas.bddf.projet.media.domain.Type;
import com.bnpparibas.bddf.projet.media.domain.Media;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "MEDIA")
public class MediaJPA {

    @Id
    //@GeneratedValue()
    @Column(name = "ID")
    private String id;

    @Column(name = "LABEL")
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;

    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "AUTHOR_SURNAME")
    private String authorSurname;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MEDIA_IMAGE_URL")
    private String mediaImageURL;

    @Column(name = "PUBLICATION_DATE")
    private LocalDate publicationDate;


    private MediaJPA() {}

    public MediaJPA(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate) {
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

    public MediaJPA(Media media) {
        this.id = media.getId();
        this.label = media.getLabel();
        this.category = media.getCategory();
        this.type = media.getType();
        this.authorName = media.getAuthorName();
        this.authorSurname = media.getAuthorSurname();
        this.description = media.getDescription();
        this.mediaImageURL = media.getMediaImageURL();
        this.publicationDate = media.getPublicationDate();
    }

    public Media toMedia(){
        return new Media(this.id,
                this.label,
                this.category,
                this.type,
                this.authorName,
                this.authorSurname,
                this.description,
                this.mediaImageURL,
                this.publicationDate); }

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
