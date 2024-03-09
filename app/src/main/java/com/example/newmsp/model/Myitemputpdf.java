package com.example.newmsp.model;

public class Myitemputpdf {

    public String name;
    public String url;

    public Myitemputpdf() {
    }

    public Myitemputpdf(String name, String url) {
        this.name = name;
        this.url = url;
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
