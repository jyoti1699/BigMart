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

public class makeup extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_makeup);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler();
        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(makeup.this, cart.class);
                startActivity(secondactivity1);
            }

        });
    }
    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.mu1,"₹5̶0̶0̶̶","DAVIDOFF","₹300","Save upto ₹50 by using coupons", (float) 3.5,"make-up brush"));
        pLocations.add(new MHelperClass(R.drawable.mu2,"₹5̶0̶0̶","CK","₹300","Save upto ₹50 by using coupons", (float) 3.5,"beauty blender"));
        pLocations.add(new MHelperClass(R.drawable.mu3,"₹5̶0̶0̶","lakeme","₹401","Save upto ₹50 by using coupons", (float) 3.5,"beauty pouch"));
        pLocations.add(new MHelperClass(R.drawable.mu4,"₹5̶0̶0̶","INOVERA","₹489","Save upto ₹50 by using coupons", (float) 3.5,"makeup kit"));
        pLocations.add(new MHelperClass(R.drawable.mu5,"₹979̶","HUDA BEAUTY","₹799","Save upto ₹50 by using coupons", (float) 3.5,"face kit"));
        pLocations.add(new MHelperClass(R.drawable.mu6,"₹5̶0̶0̶","Peora","₹399","Save upto ₹50 by using coupons", (float) 3.5,"makeup set"));
        pLocations.add(new MHelperClass(R.drawable.mu7,"₹15̶0̶0̶","MAC","₹1359","Save upto ₹50 by using coupons", (float) 3.5,"beauty kit"));
        pLocations.add(new MHelperClass(R.drawable.mu8,"₹5̶0̶0̶","Oriflame","₹300","Save upto ₹50 by using coupons", (float) 3.5,"eyeshadow palate"));
        pLocations.add(new MHelperClass(R.drawable.mu9,"₹8̶5̶0̶","Oriley","₹600","Save upto ₹100 by using coupons",4,"eyehadow palate"));
        pLocations.add(new MHelperClass(R.drawable.mu10,"₹3̶̶0̶0̶","Maybellene","₹250","Save upto ₹30 by using coupons", (float) 4.5,"compact powder"));
        pLocations.add(new MHelperClass(R.drawable.mu11,"₹2̶̶0̶0̶","Lakme","₹100","Save upto ₹10 by using coupons", (float) 3,"loose powder"));
        pLocations.add(new MHelperClass(R.drawable.mu12,"₹̶1̶5̶0̶0","Checky","₹1250","Save upto ₹150 by using coupons", (float) 5,"makeup kit and pouch"));




        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }
}