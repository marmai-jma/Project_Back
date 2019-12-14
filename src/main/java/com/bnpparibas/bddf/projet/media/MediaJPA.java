package com.bnpparibas.bddf.projet.media;

import javax.persistence.*;

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

    private MediaJPA() {}

    public MediaJPA(Media media){
        this.id =media.getId();
        this.authorName = media.getAuthorName();
        this.authorSurname = media.getAuthorSurname();
        this.category = media.getCategory();
        this.type= media.getType();
    }

    public Media toMedia(){
        return new Media();

    }    public String getId() {
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
