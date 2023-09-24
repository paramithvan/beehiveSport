package com.example.beehivesport.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beehivesport.NewsDetail;
import com.example.beehivesport.R;
import com.example.beehivesport.TicketDetail;
import com.example.beehivesport.data.NewsData;
import com.example.beehivesport.data.ScheduleData;

import java.util.ArrayList;
import java.util.Vector;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Vector<NewsData> newsData;

    public void setNewsData(Vector<NewsData> newsData) {
        this.newsData = newsData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsData Datanews = newsData.get(position);
        holder.imageNews.setImageResource(Datanews.getFoto());
        holder.newsTitle.setText(Datanews.getTitle());
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView newsTitle;
        ImageView imageNews;
        CardView cardViewNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.title_news);
            imageNews = itemView.findViewById(R.id.image_news);
            cardViewNews = itemView.findViewById(R.id.items_news);

            cardViewNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), NewsDetail.class);
                    intent.putExtra("NewsId", getAdapterPosition());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
