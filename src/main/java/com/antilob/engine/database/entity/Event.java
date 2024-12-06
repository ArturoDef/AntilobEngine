package com.antilob.engine.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name="evenements")
public class Event {

    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    private long id;

    @Column(name = "texte")
    private String text;

    private String image;

    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}



