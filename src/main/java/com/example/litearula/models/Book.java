package com.example.litearula.models;

import java.util.Scanner;

public class Book {
    private int id;
    private String author;
    private String title;
    private String language;
    private double downloadCount;

    public Book(){}
    public Book(int id, String author, String title, String language, double downloadCount) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.language = language;
        this.downloadCount = downloadCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(double downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return ", title= '" + title + '\'' +
               "id= " + id +
               ", author= '" + author + '\'' +
               ", language= '" + language + '\'' +
               ", downloadCount= " + downloadCount;

    }
}
