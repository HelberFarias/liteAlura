package com.example.litearula.models;

public class Book {
    private int id;
    private String authors;
    private String title;
    private String languages;
    private double downloadCount;

    public Book(){}
    public Book(int id, String author, String title, String language, double downloadCount) {
        this.id = id;
        this.authors = author;
        this.title = title;
        this.languages = language;
        this.downloadCount = downloadCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public double getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(double downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "title = '" + title + '\'' +
               ", id = " + id +
               ", authors = '" + authors + '\'' +
               ", language = '" + languages + '\'' +
               ", download count = " + downloadCount;
    }
}
