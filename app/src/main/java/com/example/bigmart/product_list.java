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

public class product_list extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;
    Button back,cartbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler(); back  = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(product_list.this, logged_in.class);
                startActivity(secondactivity1);
            }

        });
        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(product_list.this, cart.class);
                startActivity(secondactivity1);
            }

        });



    }

    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.perfume,"₹5̶0̶0̶̶","DAVIDOFF (Buy 2 get 1 free)","₹300","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.per,"₹5̶0̶0̶","CK","₹300","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.tanktop,"₹5̶0̶0̶","Women's Tank Top (Buy 2 get 1 free)","₹299","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.makeup,"₹5̶0̶0̶","INOVERA","₹489","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.lipstick,"₹979̶","HUDA BEAUTY LIQUID MATTE","₹799","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.earrings,"₹5̶0̶0̶","Peora Gold Plated Pearl Kundan Stone","₹399","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.bluetoothearphone,"₹15̶0̶0̶","boAt Rockerz ","₹1359","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.nnfive,"₹5̶0̶0̶","N-95 Mask (Buy 2 get 1 free)","₹300","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.san1,"₹8̶5̶0̶","Oriley Advanced Sanitizer 1000 ml","₹600","Save upto ₹100 by using coupons",4,"hh"));
        pLocations.add(new MHelperClass(R.drawable.san2,"₹3̶̶0̶0̶","Dettol Dininfectant Spray With Spring Blossom Essence","₹250","Save upto ₹30 by using coupons", (float) 4.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.volini,"₹2̶̶0̶0̶","Volini Spray With Advanced Relief Formula","₹100","Save upto ₹10 by using coupons", (float) 3,"hh"));
        pLocations.add(new MHelperClass(R.drawable.bpmachine,"₹̶1̶5̶0̶0","Blood Pressure Checker","₹1250","Save upto ₹150 by using coupons", (float) 5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.himalaya,"₹8̶5̶0","Himalaya LeanCare With Weight Management","₹650","Save upto ₹20 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.dex1,"₹3̶0̶0","DexOrange Syrup 200 ml Hemantinic Syrup with Iron, Folic Acid, Vitamin B12 ","₹250","Save upto ₹40 by using coupons", (float) 4,"hh"));
        pLocations.add(new MHelperClass(R.drawable.bpmachine2,"₹1̶7̶5̶0","OMRON Blood Pressure Meter With Advanced Storage","₹1500","Save upto ₹200 by using coupons", (float) 4,"hh"));
        pLocations.add(new MHelperClass(R.drawable.dex2,"₹3̶5̶0̶","DexOrange Tablets Hem" + "atinic Capsules 30 Capsules","₹300","Save upto ₹60 by using coupons", (float) 2.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.watchewomen,"₹8̶0̶0̶","Giordano Women's","₹599","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.perfume,"₹8̶0̶0̶","Iris Reed","₹699","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.babycare,"₹8̶0̶0̶","Baby Care","₹699","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.tp,"₹390̶","Tampax","₹299","Save upto ₹50 by using coupons", (float) 3.5,"hh"));
        pLocations.add(new MHelperClass(R.drawable.tp,"200","hh","gg","hh",(float)3.4,"ff"));




        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }

}