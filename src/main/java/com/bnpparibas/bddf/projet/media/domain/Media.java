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
    private Set<MediaNotation> mediaNotations;
    private Set<Review> reviews;

    public Media() {}

    public Media(String id, String label, Category category, Type type, String authorName, String authorSurname, String description, String mediaImageURL, LocalDate publicationDate, Set<MediaNotation> mediaNotations, Set<Review> reviews) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.description = description;
        this.mediaImageURL = mediaImageURL;
        this.publicationDate = publicationDate;
        this.mediaNotations = mediaNotations;
        this.reviews = reviews;
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

    public int computeMediaRecoNotation (){
        float likesNumber = this.getLikesNumber();
        float mediaNotationNumber = this.getMediaNotationNumber();
        return Math.round(likesNumber / mediaNotationNumber*100);
    }

    public int computeWeightedRecoNotation (){
        float likesNumber = this.getLikesNumber();
        float mediaNotationNumber = this.getMediaNotationNumber();
        return Math.round(likesNumber * likesNumber / mediaNotationNumber*100);
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

    public int getLikesNumber() {
        int likesNumber = 0;
        if (this.mediaNotations != null) {
            for (MediaNotation mediaNotation : this.mediaNotations) {
                if (mediaNotation.isLiked())
                    likesNumber++;
            }
        }
        return likesNumber;
    }

    public int getMediaNotationNumber() {
        return (this.mediaNotations == null) ? 0 : this.mediaNotations.size();
    }

    public Set<MediaNotation> getMediaNotations() {
        return mediaNotations;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
}
