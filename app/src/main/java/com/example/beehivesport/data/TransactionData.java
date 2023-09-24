package com.example.beehivesport.data;

public class TransactionData {

    public int idHistory;
    public int fotoLawan;
    public int UserId;
    public String titleMatch;
    public int idMatch;
    public int TotalHarga;
    public String jamMatch;
    public String tanggalMatch;

    public TransactionData(int idHistory, int fotoLawan, int UserId, String titleMatch, int idMatch, int totalHarga, String jamMatch, String tanggalMatch) {
        this.idHistory = idHistory;
        this.fotoLawan = fotoLawan;
        this.UserId = UserId;
        this.titleMatch = titleMatch;
        this.idMatch = idMatch;
        TotalHarga = totalHarga;
        this.jamMatch = jamMatch;
        this.tanggalMatch = tanggalMatch;
    }

    public TransactionData() {
    }

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public int getFotoLawan() {
        return fotoLawan;
    }

    public void setFotoLawan(int fotoLawan) {
        this.fotoLawan = fotoLawan;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        this.UserId = UserId;
    }

    public String getTitleMatch() {
        return titleMatch;
    }

    public void setTitleMatch(String titleMatch) {
        this.titleMatch = titleMatch;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getTotalHarga() {
        return TotalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        TotalHarga = totalHarga;
    }

    public String getJamMatch() {
        return jamMatch;
    }

    public void setJamMatch(String jamMatch) {
        this.jamMatch = jamMatch;
    }

    public String getTanggalMatch() {
        return tanggalMatch;
    }

    public void setTanggalMatch(String tanggalMatch) {
        this.tanggalMatch = tanggalMatch;
    }

}
