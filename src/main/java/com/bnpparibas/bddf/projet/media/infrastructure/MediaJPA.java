package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

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
    @org.hibernate.annotations.Type(type="text")
    private String description;

    @Column(name = "MEDIA_IMAGE_URL")
    private String mediaImageURL;

    @Column(name = "PUBLICATION_DATE")
    private LocalDate publicationDate;

    @OneToMany
    @JoinColumn(name="MEDIAJPA_ID")
    @JsonBackReference
    private Set<MediaNotationJPA> mediaNotationsJPA;

    @OneToMany
    @JoinColumn(name="MEDIAJPA_ID")
    @JsonBackReference
    private Set<ReviewJPA> reviewsJPA;

    private MediaJPA() {}

    public MediaJPA(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate, Set<MediaNotationJPA> mediaNotationsJPA) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.description = description;
        this.mediaImageURL = mediaImageURL;
        this.publicationDate = publicationDate;
        this.mediaNotationsJPA = mediaNotationsJPA;
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

    public Media jpaToMedia(){
        Set<MediaNotation> mediaNotations = null;
        if (this.mediaNotationsJPA != null) {
            mediaNotations = this.mediaNotationsJPA.stream()
                    .map(mediaNotationJPA -> new MediaNotation(mediaNotationJPA.getNotationId(), null, mediaNotationJPA.isLiked(),
                            new User(mediaNotationJPA.getUserJPA().getId(),
                                    mediaNotationJPA.getUserJPA().getLogin(),
                                    mediaNotationJPA.getUserJPA().isActive())))
                    .collect(Collectors.toSet());
        }
        Set<Review> reviews = null;
        if (this.reviewsJPA != null) {
            reviews = this.reviewsJPA.stream()
                    .map(reviewJPA -> reviewJPA.jpaToReview())
                    .collect(Collectors.toSet());
        }
        return new Media(this.getId(),
        this.getLabel(),
        this.getCategory(),
        this.getType(),
        this.getAuthorName(),
        this.getAuthorSurname(),
        this.getDescription(),
        this.getMediaImageURL(),
        this.getPublicationDate(),
        mediaNotations, reviews);
    }

    public MediaJPA(Media media, Set<MediaNotationJPA> mediaNotationJPAS) {
        this.id = media.getId();
        this.label = media.getLabel();
        this.category = media.getCategory();
        this.type = media.getType();
        this.authorName = media.getAuthorName();
        this.authorSurname = media.getAuthorSurname();
        this.description = media.getDescription();
        this.mediaImageURL = media.getMediaImageURL();
        this.publicationDate = media.getPublicationDate();
        this.mediaNotationsJPA = mediaNotationJPAS;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Category getCategory() { return category; }

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

    public Set<MediaNotationJPA> getMediaNotationsJPA() {
        return mediaNotationsJPA;
    }

    public Set<ReviewJPA> getReviewsJPA() {
        return reviewsJPA;
    }
}
