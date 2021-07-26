package com.example.bigmart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tap_activity extends AppCompatActivity {
     ImageView timage;
     TextView ttitle,tdesc,tprice,toldprice,toffer;
      Button order,AddToCart;
      FirebaseDatabase rootNode;
      DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_activity);
        ttitle = findViewById(R.id.ttitle);
        timage = findViewById(R.id.timage);
        tdesc = findViewById(R.id.tdes);
        tprice = findViewById(R.id.tprice);
        toldprice = findViewById(R.id.toldprice);
        RatingBar rb = findViewById(R.id.tbar);
        Bundle bundle = getIntent().getExtras();
        //int resId = bundle.getInt("resId");
        timage.setImageResource(bundle.getInt("resId"));
        ttitle.setText(" "+getIntent().getStringExtra("title"));
        tdesc.setText(" "+getIntent().getStringExtra("desc"));
        tprice.setText(" "+getIntent().getStringExtra("price"));
        toldprice.setText(" "+getIntent().getStringExtra("offer"));
     // toffer.setText(" "+getIntent().getStringExtra("oldprice"));
       float r = getIntent().getFloatExtra("rbar",4);
       rb.setRating(r);
        final int resId = bundle.getInt("resId");
        final String title = getIntent().getStringExtra("title");
        final String price = getIntent().getStringExtra("price");
        final String oldprice = getIntent().getStringExtra("offer");
        final String offer = getIntent().getStringExtra("oldprice");
        AddToCart  = findViewById(R.id.addtocart);
        AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("addtocart/product");
                //startActivity(new Intent(getApplicationContext(), cart.class));
                AddtocartUserhelperclass helperclass =
                        new  AddtocartUserhelperclass(title,price,oldprice,resId);
                reference.child(title).setValue(helperclass);
                Toast.makeText(tap_activity.this, "Added to cart", Toast.LENGTH_LONG).show();
            }

        });
        Button order = findViewById(R.id.torder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(tap_activity.this, OrderSummary.class);
                //startActivity(new Intent(getApplicationContext(), cart.class));
                secondactivity1.putExtra("resId",resId);
                secondactivity1.putExtra("title",title);
                secondactivity1.putExtra("price",price);
                startActivity(secondactivity1);
            }

        });
    }
}