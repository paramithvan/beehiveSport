package com.example.beehivesport.data;

public class NewsData {

    public int NewsId;
    public String title;
    public String isi;
    public int foto;

    public NewsData( int NewsId, String title, String isi, int foto) {
        this.NewsId = NewsId;
        this.title = title;
        this.isi = isi;
        this.foto = foto;
    }
    public NewsData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getNewsId() {
        return NewsId;
    }

    public void setNewsId(int newsId) {
        NewsId = newsId;
    }

}
