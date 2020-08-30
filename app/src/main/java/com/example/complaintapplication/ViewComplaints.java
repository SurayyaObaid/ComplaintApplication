package com.example.complaintapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class ViewComplaints extends AppCompatActivity {

    private GridView gridView;
        private ArrayList<String> list;
        private ArrayAdapter<String> adapter;
        MyHelper handler;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_complaints);

            gridView=(GridView) findViewById(R.id.gridView1);

        }
    }
