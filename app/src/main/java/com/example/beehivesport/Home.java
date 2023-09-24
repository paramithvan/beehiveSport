package com.example.beehivesport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends FragmentActivity {

    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        navbar = findViewById(R.id.bottom_navbar);
        navbar.setSelectedItemId(R.id.home_button);

        navbar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home_button:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new news()).commit();
                    return true;
                case R.id.schedule_button:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new schedule()).commit();
                    return true;
                case R.id.transaction_button:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new transaction()).commit();
                    return true;
                default:
                    return false;
            }
        });

    }
}