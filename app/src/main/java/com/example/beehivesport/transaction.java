package com.example.beehivesport;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beehivesport.adapter.ScheduleAdapter;
import com.example.beehivesport.adapter.TransactionAdapter;
import com.example.beehivesport.data.ScheduleData;
import com.example.beehivesport.data.TransactionData;

import java.util.ArrayList;
import java.util.Vector;

public class transaction extends Fragment {

    private RecyclerView TransRV;
    TransactionAdapter transactionAdapter;

    Vector<TransactionData> transactionDataArrayList;

    TransactionData curTrans;

    Database database;

    Integer UserId;

    TextView judulPage;
    ImageView logoLawan;
    TextView namaMatch;
    TextView tanggalMatch;
    TextView jamMatch;
    TextView totalPrice;
    ImageButton logoutApp;
    ImageView logo;
    public transaction() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TransRV = view.findViewById(R.id.recylerView_trans);

        judulPage = view.findViewById(R.id.judulPage_trans);
        logoLawan = view.findViewById(R.id.logo_lawan_trans);
        namaMatch = view.findViewById(R.id.NamaMatch_trans);
        tanggalMatch = view.findViewById(R.id.tanggalMatch_trans);
        jamMatch = view.findViewById(R.id.jamMatch_trans);
        totalPrice = view.findViewById(R.id.totalPrice_trans);
        logoutApp = view.findViewById(R.id.logout_button_trans);
        logo = view.findViewById(R.id.logo_trans);

        database = Database.getDbHelper(getContext());
        transactionDataArrayList = database.getAllTransactionUser(UserId);

        transactionAdapter = new TransactionAdapter();
        transactionAdapter.setTransactionData(transactionDataArrayList);
        TransRV.setAdapter(transactionAdapter);
        TransRV.setLayoutManager(new LinearLayoutManager(getContext()));

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