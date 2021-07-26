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

public class men extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_men);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler();

        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(men.this, cart.class);
                startActivity(secondactivity1);
            }

        });
    }


    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.c1,"₹5̶0̶0̶̶","DAVIDOFF ","₹300","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c2,"₹5̶0̶0̶","CK","₹300","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL SHIRT "));
        pLocations.add(new MHelperClass(R.drawable.c3,"₹5̶0̶0̶","CK","₹299","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL COTTON SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c4,"₹5̶0̶0̶","INOVERA","₹489","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL COTTON SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c5,"₹979̶","CK","₹799","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c6,"₹5̶0̶0̶","CK","₹399","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c7,"₹15̶0̶0̶","Rockerz ","₹1359","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c8,"₹5̶0̶0̶","CK","₹300","Save upto ₹50 by using coupons", (float) 3.5,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c9,"₹8̶5̶0̶","Oriley","₹600","Save upto ₹100 by using coupons",4,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.c10,"₹3̶̶0̶0̶","Blossom","₹250","Save upto ₹30 by using coupons", (float) 4.5,"CASUAL SHIRT"));
        pLocations.add(new MHelperClass(R.drawable.d1,"₹2̶̶0̶0̶","Volin","₹100","Save upto ₹10 by using coupons", (float) 3,"STRECHABLE PANT"));
        pLocations.add(new MHelperClass(R.drawable.d2,"₹̶1̶5̶0̶0","CHECKERS","₹1250","Save upto ₹150 by using coupons", (float) 5,"MENS CASUAL SHIRT PURE COTTON FABRIC"));
        pLocations.add(new MHelperClass(R.drawable.d3,"₹8̶5̶0","CHECKERS","₹650","Save upto ₹20 by using coupons", (float) 3.5,"T SHIRT FOR ALL USE"));
        pLocations.add(new MHelperClass(R.drawable.d4,"₹3̶0̶0","NIKIE ","₹250","Save upto ₹40 by using coupons", (float) 4,"SNICKERS"));
        pLocations.add(new MHelperClass(R.drawable.d5,"₹1̶7̶5̶0","OMRON","₹1500","Save upto ₹200 by using coupons", (float) 4,"MENS KURTA PAIJAMA SET"));
        pLocations.add(new MHelperClass(R.drawable.d6,"₹3̶5̶0̶","Hem","₹300","Save upto ₹60 by using coupons", (float) 2.5,"HODDIE LIGHT WEIGHT"));
        pLocations.add(new MHelperClass(R.drawable.d7,"₹8̶0̶0̶","Giordano","₹599","Save upto ₹50 by using coupons", (float) 3.5,"MENS SHORTS COTTON FABRIC"));
        pLocations.add(new MHelperClass(R.drawable.d8,"₹8̶0̶0̶","Iris","₹699","Save upto ₹50 by using coupons", (float) 3.5,"FORMAL SHOES"));
        pLocations.add(new MHelperClass(R.drawable.d9,"₹8̶0̶0̶","Bady Care","₹699","Save upto ₹50 by using coupons", (float) 3.5,"WINTER WEAR THERMACOAT"));
        pLocations.add(new MHelperClass(R.drawable.d10,"₹390̶","TaPOOO","₹299","Save upto ₹50 by using coupons", (float) 3.5,"WAIST BELT"));




        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }

}