package com.example.beehivesport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.contentcapture.DataRemovalRequest;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.beehivesport.data.NewsData;
import com.example.beehivesport.data.ScheduleData;
import com.example.beehivesport.data.TransactionData;

import java.util.ArrayList;
import java.util.Vector;

public class Database extends SQLiteOpenHelper {

    private static Database dbHelper;
    private SQLiteDatabase db;

    public static Database getDbHelper(Context context) {
        if (dbHelper == null){
            synchronized (Database.class){
                if (dbHelper == null){
                    dbHelper = new Database(context);
                }
            }
        }
        return dbHelper;
    }

    public Database(@Nullable Context context) {

        super(context, "Beehive.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "Create Table users (" +
                        "userId INTEGER primary key AUTOINCREMENT NOT NULL," +
                        "fullName TEXT," +
                        "email TEXT, " +
                        "password TEXT) ");
        db.execSQL(
                "Create Table News (" +
                        "NewsId INTEGER primary key," +
                        "title TEXT, " +
                        "isi TEXT, " +
                        "foto INTEGER)");
        db.execSQL(
                "Create Table Lawan (" +
                        "idLawan INTEGER primary key, " +
                        "nameLawan TEXT, " +
                        "fotoLawan INTEGER)");
        db.execSQL(
                "Create Table Matchs (" +
                        "idMatch INTEGER primary key, " +
                        "idTeam INTEGER, " +
                        "namaTeam TEXT, " +
                        "idLawan INTEGER, " +
                        "namaLawan TEXT, " +
                        "fotoTeam INTEGER," +
                        "fotoLawan INTEGER, " +
                        "timeMatch TEXT, " +
                        "dateMatch TEXT, " +
                        "tempatMatch TEXT,"+
                        "price INTEGER,"+
                        "quantity INTEGER,"+
                        "FOREIGN KEY (idLawan) REFERENCES Lawan(idLawan))");
        db.execSQL(
                "Create Table HistoryPurchase (" +
                        "idHistory INTEGER primary key, " +
                        "userId INTEGER, " +
                        "titleMatch TEXT, " +
                        "idMatch INTEGER,"+
                        "totalPrice INTEGER, " +
                        "timeMatch TEXT, " +
                        "dateMatch TEXT, " +
                        "FOREIGN KEY(userId) REFERENCES users(userId)," +
                        "FOREIGN KEY(idMatch) REFERENCES Matchs(idMatch))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists News");
        db.execSQL("drop Table if exists Lawan");
        db.execSQL("drop Table if exists Matchs");
        db.execSQL("drop Table if exists HistoryPurcase");
    }

    public Boolean insertData( String fullName, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullName", fullName);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long hasil = db.insert("users", null, contentValues);

        if (hasil == -1){
            return false;
        }else{
            return true;
        }
    }


    public void insertNews(Integer NewsId, String title, String isi, Integer foto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NewsId", NewsId);
        contentValues.put("title", title);
        contentValues.put("isi", isi);
        contentValues.put("foto", foto);

        db.insert("News", null, contentValues);
    }

    public void insertLawan(Integer idLawan, String nameLawan , Integer fotoLawan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nameLawan", nameLawan);
        contentValues.put("fotoLawan", fotoLawan);

        db.insert("Lawan", null, contentValues);
    }

    public void insertMatch(Integer idMatch, Integer idTeam , String namaTeam ,
                            Integer idLawan , String namaLawan , Integer fotoTeam,
                            Integer fotoLawan , String timeMatch , String dateMatch, String tempatMatch, Integer price, Integer quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idMatch", idMatch);
        contentValues.put("idTeam", idTeam);
        contentValues.put("namaTeam",namaTeam);
        contentValues.put("idLawan", idLawan);
        contentValues.put("NamaLawan", namaLawan);
        contentValues.put("fotoTeam",fotoTeam);
        contentValues.put("fotoLawan", fotoLawan);
        contentValues.put("timeMatch", timeMatch);
        contentValues.put("DateMatch",dateMatch);
        contentValues.put("tempatMatch", tempatMatch);
        contentValues.put("price", price);
        contentValues.put("quantity", quantity);

        db.insert("Matchs", null, contentValues);
    }

    public void insertHistoryPurchase(Integer idHistory , String titleMatch , Integer totalPrice , String timeMatch , String dateMatch ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idHistory", idHistory);
        contentValues.put("titleMatch", titleMatch);
        contentValues.put("totalPrice", String.valueOf(totalPrice));
        contentValues.put("timeMatch", timeMatch);
        contentValues.put("dateMatch", dateMatch);


        db.insert("HistoryPurchase", null, contentValues);
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ?", new String[]{email});

        return cursor.getCount() > 0;
    }

    public Boolean checkAll(String fullNam, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where fullNam = ? and email = ? and password = ?", new String[]{fullNam, email, password});

        return cursor.getCount() > 0;
    }

    public Boolean checkLogin(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ? and password = ?", new String[]{ email, password});

        return cursor.getCount() > 0;
    }

    public Boolean checkUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users", null);

        if(cursor.getCount() == 0){
            return true;
        }else{
            return false;
        }
    }

    public Vector<NewsData> getAllNews(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM News", null);

        Vector<NewsData> dataVector = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            NewsData newsData = new NewsData();
            newsData.setNewsId(cursor.getInt(0));
            newsData.setTitle(cursor.getString(1));
            newsData.setIsi(cursor.getString(2));
            newsData.setFoto(cursor.getInt(3));
            dataVector.add(newsData);
            cursor.moveToNext();
        }

        db.close();
        return dataVector;
    }

    public Vector<ScheduleData> getAllSchedule(){
//        db = dbHelper.getReadableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Matchs", null);

        Vector<ScheduleData> scheduleDataVector = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ScheduleData scheduleData = new ScheduleData();
            scheduleData.setMatchId(cursor.getInt(0));
            scheduleData.setNamaTeam(cursor.getString(2));
            scheduleData.setNamaLawan(cursor.getString(4));
            scheduleData.setTimeMatch(cursor.getString(7));
            scheduleData.setDateMatch(cursor.getString(8));
            scheduleData.setFotoTeam(cursor.getInt(5));
            scheduleData.setFotoLawan(cursor.getInt(6));
            scheduleData.setTempatMatch(cursor.getString(9));
            scheduleData.setHargaTicket(cursor.getInt(10));
            scheduleData.setQuantity(cursor.getInt(11));

            scheduleDataVector.add(scheduleData);
            cursor.moveToNext();
        }
        db.close();
        return scheduleDataVector;
    }

    public Vector<TransactionData> getAllTransactionUser(Integer UserId){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM HistoryPurchase WHERE UserId = ?",new String[]{String.valueOf(UserId)} );

        Vector<TransactionData> transactionDataVector = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            TransactionData transactionData = new TransactionData();

            transactionData.setIdHistory(cursor.getInt(0));
            transactionData.setFotoLawan(cursor.getInt(1));
            transactionData.setUserId(cursor.getInt(2));
            transactionData.setTitleMatch(cursor.getString(3));
            transactionData.setIdMatch(cursor.getInt(4));
            transactionData.setTotalHarga(cursor.getInt(5));
            transactionData.setJamMatch(cursor.getString(6));
            transactionData.setTanggalMatch(cursor.getString(7));

            transactionDataVector.add(transactionData);
            cursor.moveToNext();
        }
        db.close();
        return transactionDataVector;
    }

    public Vector<TransactionData> getAllTransaction(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM HistoryPurchase",null );

        Vector<TransactionData> transactionDataVector = new Vector<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            TransactionData transactionData = new TransactionData();

            transactionData.setIdHistory(cursor.getInt(0));
            transactionData.setFotoLawan(cursor.getInt(1));
            transactionData.setUserId(cursor.getInt(2));
            transactionData.setTitleMatch(cursor.getString(3));
            transactionData.setIdMatch(cursor.getInt(4));
            transactionData.setTotalHarga(cursor.getInt(5));
            transactionData.setJamMatch(cursor.getString(6));
            transactionData.setTanggalMatch(cursor.getString(7));

            transactionDataVector.add(transactionData);
            cursor.moveToNext();
        }
        db.close();
        return transactionDataVector;
    }


}
