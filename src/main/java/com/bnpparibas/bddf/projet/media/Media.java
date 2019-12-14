package com.bnpparibas.bddf.projet.media;

public class Media {

    private String id;
    private String label;

    private Category category;
    private Type type;

    private String authorName;
    private String authorSurname;

    public Media() {}

    public Media(String id, String label, Category category, Type type, String authorName, String authorSurname) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.type = type;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }

    public void update(Media mediaToUpdate){
        this.label=mediaToUpdate.getLabel();
        this.category=mediaToUpdate.getCategory();
        this.type=mediaToUpdate.getType();
        this.authorName=mediaToUpdate.getAuthorName();
        this.authorSurname=mediaToUpdate.getAuthorSurname();
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
