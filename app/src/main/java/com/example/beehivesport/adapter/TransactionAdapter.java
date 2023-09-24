package com.example.beehivesport.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beehivesport.R;
import com.example.beehivesport.data.ScheduleData;
import com.example.beehivesport.data.TransactionData;

import java.util.Vector;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    Vector<TransactionData> transactionData;

    public void setTransactionData(Vector<TransactionData> transactionData) {
        this.transactionData = transactionData;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        TransactionData transData = transactionData.get(position);
        holder.jam.setText(transData.getJamMatch());
        holder.tanggal.setText(transData.getTanggalMatch());
        holder.logo_lawan.setImageResource(transData.getFotoLawan());
        holder.match_title.setText(transData.getTitleMatch());
        holder.totalHarga.setText(String.valueOf(transData.getTotalHarga()));
    }

    @Override
    public int getItemCount() {
        return transactionData.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder{

        ImageView logo_lawan;
        TextView match_title;
        TextView tanggal;
        TextView jam;
        TextView totalHarga;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            logo_lawan = itemView.findViewById(R.id.logo_lawan_trans);
            match_title = itemView.findViewById(R.id.NamaMatch_trans);
            tanggal = itemView.findViewById(R.id.tanggalMatch_trans);
            jam = itemView.findViewById(R.id.jamMatch_trans);
            totalHarga = itemView.findViewById(R.id.totalPrice_trans);
        }
    }
}
