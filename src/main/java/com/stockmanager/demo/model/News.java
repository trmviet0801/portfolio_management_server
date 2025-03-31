package com.stockmanager.demo.model;

public class News {
    private String title;
    private String description;
    private String url;
    private String publisher;
    private String time;
    private String imageUrl;

    public News(){}

    public News(String title, String description, String url, String publisher, String time, String imageUrl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.publisher = publisher;
        this.time = time;
        this.imageUrl = imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTime() {
        return time;
    }
}
