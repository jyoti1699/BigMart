package com.example.bigmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class cart extends AppCompatActivity {
    RecyclerView productRecycler1;
    RecyclerView.Adapter padapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //enable full scree
        setContentView(R.layout.activity_cart);
        productRecycler1 = findViewById(R.id.crecycler);
        final String product = "product";
        Button backbtn = findViewById(R.id.go_back);


        Button removeall = findViewById(R.id.removeall);
        removeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("addtocart/product");
                ref.removeValue();
               /* Query applesQuery = ref.child("addtocart").child("product");
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });*/

                Toast.makeText(cart.this, "All items have been removed from the cart.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), product_list.class));
            }

        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(cart.this , Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), product_list.class));
            }

        });


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("addtocart");
        Query checkUsercred = reference.orderByKey().equalTo(product);
        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Iterable<DataSnapshot> snapshotIterator = snapshot.child(product).getChildren();
                    Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                    productRecycler1.setHasFixedSize(true); //contain card views..only visible that user loads
                    productRecycler1.setLayoutManager(new LinearLayoutManager(cart.this, LinearLayoutManager.VERTICAL, false));
                    ArrayList<EHelperClass> KLocations = new ArrayList<>();
                    while (iterator.hasNext()) {
                        DataSnapshot next = (DataSnapshot) iterator.next();
                        // listView.("Adrr = " +next.child("add1").getValue());
                        String title = (String) next.child("title").getValue();
                        String price = (String) next.child("price").getValue();
                        String oldprice = (String) next.child("oldprice").getValue();
                        //String resID = (String) next.child("resID").getValue();
                        int resID = Integer.valueOf(next.child("redID").getValue().toString());
                   /* arrayList.add("Name - "+docname+
                            "\nSpeciality - "+spec+
                            "\nAddress - "+addr+
                            "\nPhone - "+phone+
                            "\nRating - "+drbar);*/
                        KLocations.add(new EHelperClass(title, price,oldprice,resID));
                        padapter1 = new EAdapter(KLocations);
                        productRecycler1.setAdapter(padapter1);
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