package com.sodexo.newsplatform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_article;

    private Integer id;

    @Column(length = 1000)
    private String title;

    @Column(length = 1000)
    private String url;

    @Column(length = 1000)
    private String image_url;

    private String news_site;

    @Column(length = 2500)
    private String summary;

    private LocalDateTime created_at;
    private LocalDateTime published_at;
    private LocalDateTime updated_at;
    private boolean featured;

    public News() {

    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id) {
        this.id_article = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int idArticle) {
        this.id = idArticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String imageUrl) {
        this.image_url = imageUrl;
    }

    public String getNews_site() {
        return news_site;
    }

    public void setNews_site(String newsSite) {
        this.news_site = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }

    public LocalDateTime getPublished_at() {
        return published_at;
    }

    public void setPublished_at(LocalDateTime publishedAt) {
        this.published_at = publishedAt;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updatedAt) {
        this.updated_at = updatedAt;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}
