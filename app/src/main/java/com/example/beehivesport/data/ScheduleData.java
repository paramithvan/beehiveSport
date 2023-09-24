package com.example.beehivesport.data;

public class ScheduleData {


    public int MatchId;
    public String namaTeam;
    public String namaLawan;
    public String timeMatch;
    public String dateMatch;
    public int fotoTeam;
    public int fotoLawan;

    public String tempatMatch;
    public int hargaTicket;

    public int quantity;


    public ScheduleData(int MatchId, String namaTeam, String namaLawan, String timeMatch, String dateMatch, int fotoTeam, int fotoLawan, String tempatMatch, int hargaTicket, int quantity) {
        this.MatchId = MatchId;
        this.namaTeam = namaTeam;
        this.namaLawan = namaLawan;
        this.timeMatch = timeMatch;
        this.dateMatch = dateMatch;
        this.fotoTeam = fotoTeam;
        this.fotoLawan = fotoLawan;
        this.tempatMatch = tempatMatch;
        this.hargaTicket = hargaTicket;
        this.quantity = quantity;
    }

    public ScheduleData() {
    }

    public int getMatchId() {
        return MatchId;
    }

    public void setMatchId(int matchId) {
        MatchId = matchId;
    }

    public String getNamaTeam() {
        return namaTeam;
    }

    public void setNamaTeam(String namaTeam) {
        this.namaTeam = namaTeam;
    }

    public String getNamaLawan() {
        return namaLawan;
    }

    public void setNamaLawan(String namaLawan) {
        this.namaLawan = namaLawan;
    }

    public String getTimeMatch() {
        return timeMatch;
    }

    public void setTimeMatch(String timeMatch) {
        this.timeMatch = timeMatch;
    }

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    public int getFotoTeam() {
        return fotoTeam;
    }

    public void setFotoTeam(int fotoTeam) {
        this.fotoTeam = fotoTeam;
    }

    public int getFotoLawan() {
        return fotoLawan;
    }

    public void setFotoLawan(int fotoLawan) {
        this.fotoLawan = fotoLawan;
    }

    public String getTempatMatch() {
        return tempatMatch;
    }

    public void setTempatMatch(String tempatMatch) {
        this.tempatMatch = tempatMatch;
    }

    public int getHargaTicket() {
        return hargaTicket;
    }

    public void setHargaTicket(int hargaTicket) {
        this.hargaTicket = hargaTicket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
