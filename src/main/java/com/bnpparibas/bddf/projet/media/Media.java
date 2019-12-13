package com.bnpparibas.bddf.projet.media;

public class Media {

    private String id;
    private String label;

    private Category category;
    private Type type;

    private String authorName;
    private String authorSurname;

    public Media() {}

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
