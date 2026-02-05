package com.example.litearula.models;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
@Entity
@Table (name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int apiId;
    @Column(unique = true)
    private String title;
    private String languages;
    private double downloadCount;
    @JoinColumn(name = "author_id")
    @ManyToOne
    private Author author;

    public Book(){}
    public Book(int apiId, String title, String language, double downloadCount) {
        this.apiId = apiId;
        this.title = title;
        this.languages = language;
        this.downloadCount = downloadCount;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getApiId() {
        return apiId;
    }
    public void setApiId(int apiId) {
        this.apiId = apiId;
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
               ", apiId = " + apiId +
               ", authors = '" + author + '\'' +
               ", language = '" + languages + '\'' +
               ", download count = " + downloadCount;
    }
}
