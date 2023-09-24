package com.example.beehivesport.data;

public class UserData {
    public static int UserId;
    public String FullNam;

    public String email;
    public String password;

    public UserData(int UserId, String fullNam, String email, String password) {
        this.UserId = UserId;
        this.FullNam = fullNam;
        this.email = email;
        this.password = password;
    }
    public static int getUserId() {
        return UserId;
    }

    public static void setUserId(int userId) {
        UserId = userId;
    }

    public String getFullNam() {
        return FullNam;
    }

    public void setFullNam(String fullNam) {
        FullNam = fullNam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
