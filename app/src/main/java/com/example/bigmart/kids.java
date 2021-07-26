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

public class kids extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler();

        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(kids.this, cart.class);
                startActivity(secondactivity1);
            }

        });
    }
    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.k1,"₹5̶0̶0̶̶","TEETEE","₹300","Save upto ₹50 by using coupons", (float) 3.5,"COTTON FABRIC,STRECHABLE"));
        pLocations.add(new MHelperClass(R.drawable.k2,"₹5̶0̶0̶","CK","₹399","Save upto ₹50 by using coupons", (float) 3.5,"PRINTED BLAZER"));
        pLocations.add(new MHelperClass(R.drawable.k3,"₹5̶0̶0̶","CK","₹399","Save upto ₹50 by using coupons", (float) 3.5,"PRINTED BLAZER"));
        pLocations.add(new MHelperClass(R.drawable.k4,"₹5̶0̶0̶","ETHNO","₹489","Save upto ₹50 by using coupons", (float) 3.5,"PURE COTTON KURTA PAIJAMA"));
        pLocations.add(new MHelperClass(R.drawable.k5,"₹639̶","ETHNO","₹589","Save upto ₹50 by using coupons", (float) 3.5,"GIRL'S LEHENGA SET"));
        pLocations.add(new MHelperClass(R.drawable.k6,"₹5̶0̶0̶","DUH","₹399","Save upto ₹50 by using coupons", (float) 3.5,"BABYJUMP SUIT,SOFT FABRIC"));
        pLocations.add(new MHelperClass(R.drawable.k7,"₹6̶0̶0̶","Rockerz ","₹458","Save upto ₹50 by using coupons", (float) 3.5,"KIDS TRACK PANTS"));
        pLocations.add(new MHelperClass(R.drawable.k8,"₹15̶0̶0̶","ETHNO","₹1300","Save upto ₹50 by using coupons", (float) 3.5,"GIRL'S LEHENGA SET"));
        pLocations.add(new MHelperClass(R.drawable.k9,"₹5̶5̶0̶","Oriley ","₹600","Save upto ₹100 by using coupons",4,"GIRLS TEES SET"));
        pLocations.add(new MHelperClass(R.drawable.k10,"₹3̶̶0̶0̶","Blossom","₹250","Save upto ₹30 by using coupons", (float) 4.5,"KIDDO SLIPPERS"));
        pLocations.add(new MHelperClass(R.drawable.k11,"₹2̶̶0̶0̶","DUH","₹110","Save upto ₹10 by using coupons", (float) 3,"BABY'S TOP AND BOTTOM"));




        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }

}