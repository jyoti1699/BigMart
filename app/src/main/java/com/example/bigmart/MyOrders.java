package com.example.bigmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class MyOrders extends AppCompatActivity {
    RecyclerView moproductRecycler;
    RecyclerView.Adapter mopadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        moproductRecycler = findViewById(R.id.morecycler);
        final String product = "product";
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("orders");
        Query checkUsercred = reference.orderByKey().equalTo(product);
        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Iterable<DataSnapshot> snapshotIterator = snapshot.child(product).getChildren();
                    Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                    moproductRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
                    moproductRecycler.setLayoutManager(new LinearLayoutManager(MyOrders.this, LinearLayoutManager.VERTICAL, false));
                    ArrayList<MOHelperClass> KLocations = new ArrayList<>();
                    while (iterator.hasNext()) {
                        DataSnapshot next = (DataSnapshot) iterator.next();
                        // listView.("Adrr = " +next.child("add1").getValue());
                        String title = (String) next.child("title").getValue();
                        String price = (String) next.child("price").getValue();
                        String adress = (String) next.child("adress").getValue();
                        String phone = (String) next.child("contact").getValue();
                        String pin = (String) next.child("pin").getValue();
                        String quantity = (String) next.child("quantity").getValue();
                        String name  = (String) next.child("name").getValue();
                        //String resID = (String) next.child("resID").getValue();
                        int resID = Integer.valueOf(next.child("redID").getValue().toString());
                   /* arrayList.add("Name - "+docname+
                            "\nSpeciality - "+spec+
                            "\nAddress - "+addr+
                            "\nPhone - "+phone+
                            "\nRating - "+drbar);*/

                        KLocations.add(new MOHelperClass(title,adress, price,quantity,resID,phone,pin,name));
                        mopadapter = new MOAdapter(KLocations);
                        moproductRecycler.setAdapter(mopadapter);
                        //arrayAdapter = new ArrayAdapter<String>(doc_list.this, android.R.layout.simple_list_item_1, arrayList);
                        // listView.setAdapter(arrayAdapter);
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}