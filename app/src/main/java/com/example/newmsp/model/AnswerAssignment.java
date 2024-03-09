package com.example.newmsp.model;

public class AnswerAssignment {

    public String name;
    public String url;

    public AnswerAssignment() {
    }

    public AnswerAssignment(String name, String url) {
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
