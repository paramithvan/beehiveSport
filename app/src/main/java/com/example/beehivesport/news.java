package com.example.beehivesport;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beehivesport.adapter.NewsAdapter;
import com.example.beehivesport.adapter.ScheduleAdapter;
import com.example.beehivesport.data.NewsData;

import java.util.ArrayList;
import java.util.Vector;

public class news extends Fragment {

    private RecyclerView newsRV;
    NewsAdapter newsAdapt;
    Database database;

    Vector<NewsData> newsDataArrayList;
    ImageView fotoNews;
    TextView titleNews;
    ImageButton logoutApp;
    ImageView logo;
    public news() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsRV = view.findViewById(R.id.recylerView_News);

        fotoNews = view.findViewById(R.id.image_news);
        titleNews = view.findViewById(R.id.news_title);
        logoutApp = view.findViewById(R.id.logout_button_news);
        logo = view.findViewById(R.id.logo_news);

        database = Database.getDbHelper(getContext());
        newsDataArrayList = new Vector<>();
        newsDataArrayList = database.getAllNews();
        newsAdapt = new NewsAdapter();
        newsAdapt.setNewsData(newsDataArrayList);

        newsRV.setAdapter(newsAdapt);
        newsRV.setLayoutManager(new LinearLayoutManager(getContext()));

        logoutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}