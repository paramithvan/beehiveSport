package com.example.beehivesport;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beehivesport.adapter.ScheduleAdapter;
import com.example.beehivesport.data.NewsData;
import com.example.beehivesport.data.ScheduleData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Vector;

public class schedule extends Fragment {

    private RecyclerView ScheduleRV;
    ScheduleAdapter scheduleAdapter;
    Database database;

    Vector<ScheduleData> scheduleDataArrayList;
    TextView judulPage;
    TextView namaTeam;
    TextView namaLawan;
    ImageView logoTeam;
    ImageView logoLawan;
    TextView tanggal;
    TextView jam;
    ImageButton logoutApp;
    ImageView logo;
    public schedule() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScheduleRV = view.findViewById(R.id.recylerView_Schedule);

        judulPage = view.findViewById(R.id.Match_tv_schedule);
        namaTeam = view.findViewById(R.id.beehive_tv_schedule);
        namaLawan = view.findViewById(R.id.musuh_tv_schedule);
        logoTeam = view.findViewById(R.id.image_lawan_schedule);
        logoLawan = view.findViewById(R.id.image_lawan_schedule);
        tanggal = view.findViewById(R.id.tanggal_tv_schedule);
        jam = view.findViewById(R.id.jam_tv_schedule);
        logoutApp = view.findViewById(R.id.logout_button_schedule);
        logo = view.findViewById(R.id.logo_schedule);

        database = Database.getDbHelper(getContext());
        scheduleDataArrayList = new Vector<>();
        scheduleDataArrayList = database.getAllSchedule();
        scheduleAdapter = new ScheduleAdapter();
        scheduleAdapter.setScheduleData(scheduleDataArrayList);


        ScheduleRV.setAdapter(scheduleAdapter);
        ScheduleRV.setLayoutManager(new LinearLayoutManager(getContext()));

        logoutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    private void logout(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}