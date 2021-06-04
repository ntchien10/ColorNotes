package com.example.api_example;

public class POST {
    int albumId;
    String title, URL, thumbnaiUrl;

    public POST(int ID, String title, String URL, String thumbnaiUrl) {
        this.albumId = albumId;
        this.title = title;
        this.URL = URL;
        this.thumbnaiUrl = thumbnaiUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getThumbnaiUrl() {
        return thumbnaiUrl;
    }

    public void setThumbnaiUrl(String thumbnaiUrl) {
        this.thumbnaiUrl = thumbnaiUrl;
    }
}
