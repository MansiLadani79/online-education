package com.example.newmsp.model;

public class Assignment {

    public String name;
    public String url;
    public String Link;
    public String Image;

    public Assignment() {
    }

    public Assignment(String name, String url, String link, String image) {
        this.name = name;
        this.url = url;
        this.Link = link;
        this.Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
