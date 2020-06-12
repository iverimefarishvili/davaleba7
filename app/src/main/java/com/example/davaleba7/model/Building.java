package com.example.davaleba7.model;

public class Building {
    private String descriptionEN ;
    private String titleEN;
    private String cover ;

    public Building() {
    }

    public Building(String descriptionEN, String titleEN, String cover) {
        this.descriptionEN = descriptionEN;
        this.titleEN = titleEN;
        this.cover = cover;
    }

    public String getDescription() {
        return descriptionEN;
    }

    public String getTitle() {
        return titleEN;
    }

    public String getCover() {
        return cover;
    }

    public void setDescription(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public void setTitle(String titleEN) {
        this.titleEN = titleEN;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
