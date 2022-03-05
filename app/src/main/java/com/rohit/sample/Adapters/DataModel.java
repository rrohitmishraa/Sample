package com.rohit.sample.Adapters;

public class DataModel {
    String Author, ImageUrl;

    public DataModel(String author, String imageUrl) {
        Author = author;
        ImageUrl = imageUrl;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
