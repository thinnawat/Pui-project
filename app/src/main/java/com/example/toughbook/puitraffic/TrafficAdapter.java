package com.example.toughbook.puitraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Toughbook on 15/10/2559.
 */

public class TrafficAdapter extends BaseAdapter {

    //Explicit
    private Context context;    //ท่อรับส่งข้อมูล
    private String[] titleStrings, detailStriing;
    private int[] ints;

    private TextView titleTextView, detailTextView;
    private ImageView imageView;


    public TrafficAdapter(Context context, String[] titleStrings, String[] detailStriing, int[] ints) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStriing = detailStriing;
        this.ints = ints;


    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = layoutInflater.inflate(R.layout.traffic_listview, parent, false);
        View view = layoutInflater.inflate(R.layout.traffic_listview, parent, false);


        //Bind Widget

        titleTextView = (TextView) view.findViewById(R.id.textView2);
        detailTextView = (TextView) view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        //show view
        titleTextView.setText(titleStrings[position]);

        //การตัดคำ โดยจะแสดงผลแคต่ 30 ตัวอักษรเท่านั้น  แต่ถ้าน้อยกว่า  ให้แสดงให้หมด

        if (detailStriing[position].length() <= 30) {
            //ถ้ารายละเอียดน้อยกว่า 30 ตัวอักษร
            detailTextView.setText(detailStriing[position]);
        } else {
            //ถ้ารายละเอียดน,มากกว่า 30 ตัวอักษร
            detailTextView.setText(detailStriing[position].substring(0, 30) + "...");

        }
        imageView.setImageResource(ints[position]);

        return view;
    }
}   //Main Class
