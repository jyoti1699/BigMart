package com.example.bigmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;

public class women extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler();

        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(women.this, cart.class);
                startActivity(secondactivity1);
            }

        });
    }
    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.e1,"₹5̶0̶0̶̶","Liplo","₹300","Save upto ₹50 by using coupons", (float) 3.5,"women ethnic set"));
        pLocations.add(new MHelperClass(R.drawable.e2,"₹5̶0̶0̶","CK","₹300","Save upto ₹50 by using coupons", (float) 3.5,"cotton ethnic set"));
        pLocations.add(new MHelperClass(R.drawable.e3,"₹5̶0̶0̶","Stree Feel","₹299","Save upto ₹50 by using coupons", (float) 3.5,"ethnic set"));
        pLocations.add(new MHelperClass(R.drawable.g1,"₹5̶0̶0̶","INOVERA","₹489","Save upto ₹50 by using coupons", (float) 3.5,"party gown"));
        pLocations.add(new MHelperClass(R.drawable.g4,"₹979̶","HUDayei","₹799","Save upto ₹50 by using coupons", (float) 3.5,"wedding party gown"));
        pLocations.add(new MHelperClass(R.drawable.g7,"₹5̶0̶0̶","Peora ","₹399","Save upto ₹50 by using coupons", (float) 3.5,"casual dress"));
        pLocations.add(new MHelperClass(R.drawable.s1,"₹15̶0̶0̶","Hema ","₹1359","Save upto ₹50 by using coupons", (float) 3.5,"party wear saree"));
        pLocations.add(new MHelperClass(R.drawable.s2,"₹5̶0̶0̶","Hema","₹300","Save upto ₹50 by using coupons", (float) 3.5,"casual saree"));
        pLocations.add(new MHelperClass(R.drawable.s3,"₹8̶5̶0̶","Oril","₹600","Save upto ₹100 by using coupons",4,"cotton saree"));
        pLocations.add(new MHelperClass(R.drawable.s4,"₹3̶̶0̶0̶","Blossom","₹250","Save upto ₹30 by using coupons", (float) 4.5,"wedding saree"));
        pLocations.add(new MHelperClass(R.drawable.s8,"₹2̶̶0̶0̶","Volini Spray With Advanced Relief Formula","₹100 per piece","Save upto ₹10 by using coupons", (float) 3,"saree set "));




        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }

}