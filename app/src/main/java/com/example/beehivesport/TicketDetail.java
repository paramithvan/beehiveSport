package com.example.beehivesport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beehivesport.adapter.ScheduleAdapter;
import com.example.beehivesport.adapter.TransactionAdapter;
import com.example.beehivesport.data.ScheduleData;
import com.example.beehivesport.data.TransactionData;

import java.util.ArrayList;
import java.util.Vector;

public class TicketDetail extends AppCompatActivity {

    ScheduleAdapter scheduleAdapter;

    Vector<ScheduleData> ScheduleData;
    ScheduleData curSchedule;

    Database database;

    Integer MatchId;

    ImageButton backbtn;
    TextView judulPage;
    ImageView logoBeehive;
    TextView NamaBeehive;
    TextView Vs;
    ImageView logoLawan;
    TextView NamaLawan;
    TextView tanggal;
    TextView tempat;
    TextView jam;
    TextView tulisanPrice;
    TextView totalHarga;
    TextView tulisanqty;
    EditText qty;
    Button buy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        getSupportActionBar().hide();

        backbtn = findViewById(R.id.back_btn_ticket);
        judulPage= findViewById(R.id.judulPage_ticket);
        logoBeehive= findViewById(R.id.logoBeehive_ticket);
        NamaBeehive= findViewById(R.id.namaBeehive_ticket);
        Vs= findViewById(R.id.vs_tv_ticket);
        logoLawan= findViewById(R.id.logoLawan_ticket);
        NamaLawan= findViewById(R.id.namaLawan_ticket);
        tanggal= findViewById(R.id.tanggal_ticket);
        tempat= findViewById(R.id.tempat_ticket);
        jam= findViewById(R.id.jam_ticket);
        tulisanPrice= findViewById(R.id.price_tv_ticket);
        totalHarga= findViewById(R.id.angkaHarga_ticket);
        tulisanqty= findViewById(R.id.quantity_tv_ticket);
        qty= findViewById(R.id.quantity_edt_ticket);

        buy= findViewById(R.id.buy_btn_ticket);

        MatchId = getIntent().getIntExtra("MatchId", 0);
        database = Database.getDbHelper(this);
        ScheduleData = database.getAllSchedule();
        curSchedule = ScheduleData.elementAt(MatchId);

        logoBeehive.setImageResource(curSchedule.getFotoTeam());
        NamaBeehive.setText(curSchedule.getNamaTeam());
        logoLawan.setImageResource(curSchedule.getFotoLawan());
        NamaLawan.setText(curSchedule.getNamaLawan());
        tanggal.setText(curSchedule.getDateMatch());
        tempat.setText(curSchedule.getTempatMatch());
        jam.setText(curSchedule.getTimeMatch());
        totalHarga.setText(String.valueOf(curSchedule.getHargaTicket()));


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.insertHistoryPurchase(database.getAllTransaction().size(), curSchedule.namaLawan, curSchedule.getHargaTicket(), curSchedule.timeMatch,curSchedule.dateMatch);
                finish();
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}