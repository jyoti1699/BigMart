package com.example.bigmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextInputLayout email1,passwd1;
    ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
       // FirebaseDatabase database = FirebaseDatabase.getInstance();
       // DatabaseReference myRef = database.getReference("User");
        //myRef.setValue("Meenu pagal hai ");
        pg = findViewById(R.id.progressbar);
        pg.setVisibility((View.GONE));
        email1 = findViewById(R.id.email);
        passwd1 = findViewById(R.id.passwd);
        Button reg = (Button) findViewById(R.id.regist);
        Button skipbtn=(Button)findViewById(R.id.skip);
        Button fp=(Button)findViewById(R.id.fp);

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(MainActivity.this, logged_in.class);
                startActivity(secondactivity1);
            }

        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(MainActivity.this, register.class);
                startActivity(secondactivity1);
            }

        });
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                //secondactivity1.setClass(MainActivity.this, dbooking.class);
                startActivity(secondactivity1);
            }
        });

    }

    private Boolean validatePhone() {
        String val = email1.getEditText().getText().toString();
        String phonepattern = "[0-9]{10}";
        if (val.isEmpty()) {
            email1.setError("Field cannot be empty");
            return false;
        } else   if(!val.matches(phonepattern)) {
            {
                email1.setError("Inavlid phone");
                return false;
            }

        } else {
            email1.setError(null);
            return true;
        }
    } //shows error if we dintt enter validpjn nd p/w
    private Boolean validatePass() {
        String val = passwd1.getEditText().getText().toString();
        if (val.isEmpty()) {
            passwd1.setError("Field cannot be empty");
            return false;
        } else {
            passwd1.setError(null);
            passwd1.setErrorEnabled(false);
            return true;
        }
    }
    public void sin(View view) {
        if(!validatePhone() || !validatePass()) {
            return;
        }
        pg.setVisibility((View.VISIBLE));  //pg:progress bar
        isUser();
    }
    private void isUser() {
        final String userphone = email1.getEditText().getText().toString().trim();
        final String userpass = passwd1.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Usercred");
        Query checkUsercred = reference.orderByChild("phone").equalTo(userphone);

        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    email1.setError(null);
                    email1.setErrorEnabled(false);
                    String passwordfromDB = snapshot.child(userphone).child("pass").getValue(String.class);

                    if (passwordfromDB.equals(userpass)) {
                        email1.setError(null);
                        email1.setErrorEnabled(false);
                        // String mailfromDB = snapshot.child(usermail).child("mail").getValue(String.class);
                        //String phonefromDB = snapshot.child(usermail).child("phone").getValue(String.class);
                        Intent secondactivity1 = new Intent();
                        secondactivity1.setClass(MainActivity.this, logged_in.class);
                        startActivity(secondactivity1);

                    } else {
                        pg.setVisibility((View.GONE));
                        passwd1.setError("Wrong password");
                        passwd1.requestFocus();
                    }
                }
                else
                {
                    pg.setVisibility((View.GONE));
                    email1.setError("No such user exist");
                    email1.requestFocus();//marks red
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}