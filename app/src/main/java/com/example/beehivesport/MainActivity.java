package com.example.beehivesport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.beehivesport.data.UserData;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    Button signupBtn;

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate: Login Page");
        getSupportActionBar().hide();

        database = Database.getDbHelper(this);


        loginBtn = findViewById(R.id.login_depan);
        signupBtn = findViewById(R.id.signUp_depan);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

            if(database.checkUser()){
                database.insertData("Admin", "Admin@gmail.com", "admin11");
                database.insertNews(0, "SEA Games 2023 Kamboja: Timnas Voli Indonesia Diharapkan Cetak Hattrick",
                        "rings Voli Indonesia akan berpartisipasi di SEA Games 2023 yang akan diselenggarakan di Kamboja. Timnas Voli Indonesia telah mempersiapkan diri dengan matang untuk mempertahankan gelar juara yang mereka dapatkan pada SEA Games 2015, 2017, dan 2019.\n" + "\n" +
                        "Pelatih Timnas Voli Indonesia, Imam Nahrawi, menyatakan bahwa persiapan tim sudah dimulai sejak awal tahun ini. Mereka telah melakukan berbagai latihan fisik dan teknik, serta memperkuat kerja sama dan strategi dalam tim. Namun, Nahrawi menyadari bahwa persaingan di SEA Games 2023 akan semakin ketat karena negara-negara seperti Thailand, Vietnam, dan Filipina juga memiliki tim voli yang kuat.\n" + "\n" +
                        "Untuk itu, Timnas Voli Indonesia akan menghadapi beberapa uji coba dengan tim-tim dari negara lain untuk meningkatkan kemampuan dan memperbaiki kekurangan. Selain itu, mereka juga akan mempelajari kekuatan dan kelemahan dari lawan-lawan mereka.\n" +
                        "\n" + "Timnas Voli Indonesia akan berusaha keras untuk mencetak hattrick kemenangan pada SEA Games 2023 dan membawa pulang medali emas untuk Indonesia. Para pemain juga berharap dapat memberikan yang terbaik untuk negara dan rakyat Indonesia.", R.drawable.news1);
                database.insertNews(1,"Kemenangan Beehive Sport pada kompetisi Nasional 2023", "Beehive Sport berhasil meraih kemenangan gemilang dalam ajang voli nasional 2023. Sebagai salah satu club olahraga voli terkemuka, Beehive Sport berhasil menunjukkan performa terbaik mereka dalam setiap pertandingan dan berhasil memenangkan sejumlah pertandingan dengan skor yang cukup meyakinkan.\n" + "\n" +
                        "Dalam pertandingan final yang berlangsung di arena voli nasional, Beehive Sport berhasil mengalahkan tim lawan dengan skor 3-0 dalam setiap setnya. Para pemain Beehive Sport memperlihatkan kekompakan dan kemampuan teknik yang mumpuni, serta strategi yang matang dalam setiap pertandingan.\n" +
                        "\n" + "Kemenangan ini membuktikan bahwa Beehive Sport memiliki potensi yang besar dalam dunia olahraga voli nasional dan mereka berencana untuk terus meningkatkan kemampuan dan prestasi di masa depan. Pelatih Beehive Sport, Rudi Hermawan, mengatakan bahwa kemenangan ini adalah hasil dari kerja keras dan persiapan yang matang selama beberapa bulan terakhir.\n" +
                        "\n" + "Para pemain Beehive Sport merasa sangat bahagia dan bangga dengan kemenangan mereka dalam ajang voli nasional 2023 ini. Mereka berharap dapat terus meraih prestasi yang lebih baik lagi di masa depan dan membawa nama baik Beehive Sport serta Indonesia di kancah olahraga voli internasional.",R.drawable.news2);
                database.insertNews(2, "Timnas Voli Putri Indonesia Takluk dari Korea Selatan karena Banyak Melakukan Kesalahan", "Pelatih timnas voli putri Indonesia, Mohamad Ansori, menyayangkan kekalahan 0-3 dari Korea Selatan pada babak perempat final Asian Games 2018 yang berlangsung di Tennis Indoor Gelora Bung Karno, Rabu (29/8/2018) sore WIB. Ansori menilai, anak asuhnya terlalu banyak mengulang kesalahan.\n" +
                        "\n" + "Pada pertandingan tersebut, Indonesia sempat mampu mengimbangi permainan Korea Selatan pada set pertama. Namun, permainan efektif yang dilakukan lawan harus membuat Indonesia takluk 22-25.\n" +
                        "\n" + "Memasuki set kedua, Korea Selatan semakin agresif. Sejumlah upaya yang dilakukan Indonesia, mampu diblok dengan baik oleh Korea Selatan yang unggul dari segi fisik. Set kedua kembali dimenangi dengan skor telak 13-25.\n" +
                        "\n" + "Pada set ketiga, Indonesia sebenarnya mampu menunjukkan permainan terbaik. Akan tetapi, sejumlah peluang gagal dimaksimalkan sehingga harus menyerah 18-25 dari Korea Selatan.\n" +
                        "\n" + "\"Pemain anak-anak sangat luar biasa dan tanpa ada beban, akan tetapi Korea unggul lebih dari segi fisiknya. Saat kita mau unggul, moodnya tidak dapat,\" kata Ansori seusai pertandingan.\n" +
                        "\n" + "\"Sebenarnya kami pada set pertama sudah ada perlawanan ya, mungkin salah-salah sedikit poinnya jadi anjlok. Terlalu banyak kesalahan. Mudah-mudahan besok kita tidak mengulangi kesalahan itu lagi,\" ucap Ansori.\n" +
                        "\n" + "Meski demikian, Ansori tetap melayangkan pujian terhadap mental anak asuhnya. Menurut dia, anak asuhnya bermain tanpa tekanan meskipun menghadapi tim tangguh seperti Korea Selatan.\n" +
                        "\n" + "\"Anak-anak mentalnya luar biasa ya. Jadi, tadi keberaniannya tuh tidak menganggap Korea tim paling tangguh. Jadi, seolah-olah selevel dengan kita. Akhirnya, berkat dukungan penonton juga anak-anak jadi semangat,\" ujar Ansori.\n" +
                        "\n" + "Kekalahan ini membuat Indonesia harus tersingkir dalam perburuan medali Asian Games 2018. Namun, Amalia Fajrina Nabila dkk masih berpeluang meraih peringkat kelima melawan Vietnam pada 31 Agustus mendatang.",R.drawable.news3 );
                database.insertLawan(0, "Beehive", R.drawable.logo);
                database.insertLawan(1, "Hanover United", R.drawable.lawan1);
                database.insertLawan(2, "Shodwe", R.drawable.lawan2);
                database.insertLawan(3, "Bogor", R.drawable.lawan3);
                database.insertLawan(4, "Fauget", R.drawable.lawan4);
                database.insertLawan(5, "Hanover", R.drawable.lawan5);
                database.insertMatch(0,0, "Beehive", 1, "Hanover United", R.drawable.logo,R.drawable.lawan1, "15.00 WIB", "5 May 2023", "Gelora Bung Karno",150000, 1);
                database.insertMatch(1,0, "Beehive", 2, "Shodwe", R.drawable.logo,R.drawable.lawan2, "09.00 WIB", "11 Juni 2023", "GOR Soemantri Brodjonegoro", 75000, 2);
                database.insertMatch(2,0, "Beehive", 3, "Bogor", R.drawable.logo,R.drawable.lawan3, "10.00 WIB", "28 Juli 2023", "Lapangan Voli Merpati", 50000, 1);
                database.insertMatch(3,0, "Beehive", 4, "Fauget", R.drawable.logo,R.drawable.lawan4, "17.00 WIB", "16 Agustus 2023", "Volley Paradise", 25000, 1);
                database.insertMatch(4,0, "Beehive", 5, "Hanover", R.drawable.logo,R.drawable.lawan5, "10.00 WIB", "18 Oktober 2023", "Volley Field", 75000, 1);
                database.insertHistoryPurchase(0, "Beehive VS Hanover United", 150000, "15.00 WIB", "5 May 2023");
            }

    }


}