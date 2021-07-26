package com.example.bigmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView ab  = findViewById(R.id.ab);
        ab.setText("Developed By : Meenakshi\n\t\t\t\t\t\t\t\t\t\t    Mansoor Ali\n\t\t\t\t\t\t\t\t\t\t     Akram Khan\n\t\t\t\t\t\t\t\t\t\t    Pawan kumar\n\t\t\t\t\t\t\t\t\t\t    Parshuram  \n\n Version 1.0.1");
    }
}