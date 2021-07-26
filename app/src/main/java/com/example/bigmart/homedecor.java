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

public class homedecor extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homedecor);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler();

        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(homedecor.this, cart.class);
                startActivity(secondactivity1);
            }

        });
    }
    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.hd1,"₹5̶0̶0̶̶","Roy arts","₹300","Save upto ₹50 by using coupons", (float) 3.5,"Sheesham Wood Wrought Iron Decorative Wall Hanging"));
        pLocations.add(new MHelperClass(R.drawable.hd2,"₹5̶0̶0̶","Jenek","₹300","Save upto ₹50 by using coupons", (float) 3.5,"Wall Sticker 'Branches With Flowers And Birds Cages Home Decoration"));
        pLocations.add(new MHelperClass(R.drawable.hd3,"₹5̶0̶0̶","Trimulla","₹299","Save upto ₹50 by using coupons", (float) 3.5,"Hanging Ceiling Pendant Light Metal Antique Cycle Shape"));
        pLocations.add(new MHelperClass(R.drawable.hd4,"₹5̶0̶0̶","INOVesta","₹489","Save upto ₹50 by using coupons", (float) 3.5,"Sadow Ganesha Tealight Candle Holder"));
        pLocations.add(new MHelperClass(R.drawable.hd5,"₹979̶","HUDUIMA","₹799","Save upto ₹50 by using coupons", (float) 3.5," Gold Color Metal Bird cage Tea Light Holder with Flower Vine for Home Décor"));
        pLocations.add(new MHelperClass(R.drawable.hd6,"₹5̶0̶0̶","Pearl Kundan","₹399","Save upto ₹50 by using coupons", (float) 3.5," Set of 4 Baby Hat Monk Buddha Idols Showpiece - Car Dashboard-Home Decor with Diwali Card"));
        pLocations.add(new MHelperClass(R.drawable.hd7,"₹15̶0̶0̶","BERUAWSA ","₹1359","Save upto ₹50 by using coupons", (float) 3.5,"Storeshub Golden Hancrafted Palm Buddha Polyresin Showpiece for Home Decor| Best Gift Item for House Warming/Birthdays Statue for Office and Study Table"));





        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }
}