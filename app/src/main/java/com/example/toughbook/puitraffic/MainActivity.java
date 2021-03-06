package com.example.toughbook.puitraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Explicit การประกาศตัวแปร
    private ListView listView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.livtraffic);
        button = (Button) findViewById(R.id.button);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Sound Effecf
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
                        R.raw.mosquito);
                mediaPlayer.start();

                //Show WebView
                String url = "https://www.youtube.com/watch?v=IcQXbgN1TZg";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }  //onclick
        });

        //listview Controller
        //Get value from Class
        MyContant myContant = new MyContant();
        final int[] ints = myContant.getInts();


        //Get Value Form xml
        final String[] titleStrings = getResources().getStringArray(R.array.title);
        final String[] detailString = getResources().getStringArray(R.array.detail);


        //Create Listview

        TrafficAdapter trafficAdapter = new TrafficAdapter(MainActivity.this,
                titleStrings, detailString, ints);
        listView.setAdapter(trafficAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActity.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Image", ints[position]);
                intent.putExtra("Detail", detailString[position]);
                startActivity(intent);





            }
        });





    } //Main Method กลุ่มของคำสั่ง
} //Main Class นี่คือคลาสหลัก
