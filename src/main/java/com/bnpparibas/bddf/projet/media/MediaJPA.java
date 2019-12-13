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

}
