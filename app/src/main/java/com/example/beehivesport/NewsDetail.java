package com.example.beehivesport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beehivesport.adapter.NewsAdapter;
import com.example.beehivesport.data.NewsData;

import org.w3c.dom.Text;

import java.util.Vector;

public class NewsDetail extends AppCompatActivity {

    NewsAdapter newsAdapter;

    Vector<NewsData> newsData;

    NewsData curNews;

    Integer NewsId;

    Database database;

    ImageButton backBtn;
    TextView news_atas;
    ImageView news_foto;
    TextView isi_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        backBtn = findViewById(R.id.back_btn_newsdet);
        news_atas = findViewById(R.id.news_tv);
        news_foto = findViewById(R.id.image_news_detail);
        isi_news = findViewById(R.id.berita_tv);

        NewsId = getIntent().getIntExtra("NewsId", 0);
        database = Database.getDbHelper(this);
        newsData = database.getAllNews();
        curNews = newsData.elementAt(NewsId);

        news_foto.setImageResource(curNews.getFoto());
        isi_news.setText(curNews.getIsi());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}