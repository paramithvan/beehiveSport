package com.example.beehivesport.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beehivesport.Login;
import com.example.beehivesport.MainActivity;
import com.example.beehivesport.R;
import com.example.beehivesport.TicketDetail;
import com.example.beehivesport.data.ScheduleData;

import java.util.ArrayList;
import java.util.Vector;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    Vector<ScheduleData> scheduleData;

    public void setScheduleData(Vector<ScheduleData> scheduleData) {
        this.scheduleData = scheduleData;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        ScheduleData dataMatch = scheduleData.get(position);
        holder.imageLawan.setImageResource(dataMatch.getFotoLawan());
        holder.imageTeam.setImageResource(dataMatch.getFotoTeam());
        holder.jam.setText(dataMatch.getTimeMatch());
        holder.nameLawan.setText(dataMatch.getNamaLawan());
        holder.nameTeam.setText(dataMatch.getNamaTeam());
        holder.tanggal.setText(dataMatch.getDateMatch());
    }

    @Override
    public int getItemCount() {

        return scheduleData.size();
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder{

        TextView nameTeam;
        ImageView imageTeam;
        TextView jam;
        TextView tanggal;
        TextView nameLawan;
        ImageView imageLawan;

        CardView cardViewSchedule;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTeam = itemView.findViewById(R.id.beehive_tv_schedule);
            imageTeam = itemView.findViewById(R.id.image_team_schedule);
            jam = itemView.findViewById(R.id.jam_tv_schedule);
            tanggal = itemView.findViewById(R.id.tanggal_tv_schedule);
            nameLawan = itemView.findViewById(R.id.musuh_tv_schedule);
            imageLawan = itemView.findViewById(R.id.image_lawan_schedule);
            cardViewSchedule = itemView.findViewById(R.id.items_schedule);

            cardViewSchedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), TicketDetail.class);
                    intent.putExtra("MatchId", getAdapterPosition());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}
