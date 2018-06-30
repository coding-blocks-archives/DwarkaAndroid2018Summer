package com.codingblocks.githubapi;

class Article {

    private Source source;
    private String author, title, description, url, urlToImage, pulishedAt;

    public Article() {
    }

    public Article(Source source, String author, String title, String description, String url, String urlToImage, String pulishedAt) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.pulishedAt = pulishedAt;
    }

    public Source getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
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

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPulishedAt() {
        return pulishedAt;
    }
}
