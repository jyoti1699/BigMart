package com.example.bigmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class logged_in extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView featuredRecycler,mRecycler;
    ImageButton menbtn;
    RecyclerView.Adapter adapter,madapter;
    private ViewPager mpager;
    private int[] layouts = {R.layout.first_slide,R.layout.sec_slide,R.layout.third_slide,R.layout.fourth_slide,
            R.layout.fifth_slide,R.layout.sixth_slide,R.layout.seventh_slide,};
    private MpagerAdapter mpagerAdapter;
    private LinearLayout Dots_Layout;
    private ImageView[] dots;
    Button book,v1,v2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);

        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_myacc);
        v1 = (Button) findViewById(R.id.vall1);

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, product_list.class);
                startActivity(secondactivity1);
            }
        });

        menbtn = (ImageButton) findViewById(R.id.button);
        ImageButton womenbtn = (ImageButton) findViewById(R.id.button2);
        ImageButton  kidbtn = (ImageButton) findViewById(R.id.button3);
        ImageButton makeupbtn = (ImageButton) findViewById(R.id.button4);
        ImageButton hdbtn = (ImageButton) findViewById(R.id.button5);


        menbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, men.class);
                startActivity(secondactivity1);
            }
        });

        womenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, kids.class);
                startActivity(secondactivity1);
            }
        });

        kidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, women.class);
                startActivity(secondactivity1);
            }
        });

        makeupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, makeup.class);
                startActivity(secondactivity1);
            }
        });

        hdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, homedecor.class);
                startActivity(secondactivity1);
            }
        });


        mpager = (ViewPager) findViewById(R.id.viewpager);
        mpagerAdapter=new MpagerAdapter(layouts,this);
        mpager.setAdapter(mpagerAdapter);
        featuredRecycler = findViewById(R.id.featured_recycler);
        mRecycler = findViewById(R.id.mrecycler);
        mRecycler();
        featuredRecycler();
        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);
        createDots(0);
        mpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeatureHelperClass> featureLocations = new ArrayList<>();
        featureLocations.add(new FeatureHelperClass(R.drawable.laptop,"Dell Vostro","Dell Vostro 3401 14inch FHD AG 2 Side Narrow Border Display Laptop (10th gen i3-1005G1)"));
        featureLocations.add(new FeatureHelperClass(R.drawable.mobile,"Samsung Galexy M51","Samsung Galaxy M51 (Electric Blue, 8GB RAM, 128GB Storage)"));
        featureLocations.add(new FeatureHelperClass(R.drawable.trimmer,"Kubra Trimmer","Kubra KB-2026 Rechargeable Cordless 45 Minutes Hair and Beard Trimmer For Men (Black)"));
        featureLocations.add(new FeatureHelperClass(R.drawable.ac,"Panasonic AC","Panasonic 1.5 Ton 5 Star Wi-Fi Twin Cool Inverter Split AC (Copper, PM 2.5 Filter, 2020 Model, CS/CU-NU18WKYW White)"));
        featureLocations.add(new FeatureHelperClass(R.drawable.toaster,"Prestige Toaster","Prestige PGMFB 800 Watt Grill Sandwich Toaster with Fixed Grill Plates"));
        featureLocations.add(new FeatureHelperClass(R.drawable.earbuds,"boAt Airdopes","boAt Airdopes 441 TWS Ear-Buds with IWP Technology, Immersive Audio, Up to 30H Total Playback, IPX7 Water Resistance"));

        adapter = new FeatureAdapter(featureLocations);
        featuredRecycler.setAdapter(adapter);

    }

    private void mRecycler() {
        mRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        mRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<MostHelperClass> mLocations = new ArrayList<>();
        mLocations.add(new MostHelperClass(R.drawable.mensethnic,"60% 0ff","Men's Ethnic Collection","₹699 - ₹2999 "));
        mLocations.add(new MostHelperClass(R.drawable.womensethnic,"60% 0ff","Women's Ethnic Collection","₹699 - ₹2999"));
        mLocations.add(new MostHelperClass(R.drawable.laptop,"60% 0ff","Dell Vostro 3569","₹45000"));
        mLocations.add(new MostHelperClass(R.drawable.tv,"45% 0ff","One Plus 138.8","₹48000"));
        mLocations.add(new MostHelperClass(R.drawable.fridge,"60% 0ff","Godrej 236 L 2","₹25000"));
        mLocations.add(new MostHelperClass(R.drawable.womensandals,"30% 0ff","Women's Sandals","₹500"));
        mLocations.add(new MostHelperClass(R.drawable.womenwinter,"60% 0ff","Special Women's Winter Collection","₹999 - ₹2999"));
        mLocations.add(new MostHelperClass(R.drawable.washingmachine,"50% 0ff","Whirlpool 7 Kg 5 Star","₹15000"));
        mLocations.add(new MostHelperClass(R.drawable.kidsethnic,"40% 0ff","Kid's Ethnic Collection","₹999 - ₹2999"));
        mLocations.add(new MostHelperClass(R.drawable.smartwatches,"60% 0ff","Smart Watches","₹1300"));




        madapter = new MostAdapter(mLocations);
        mRecycler.setAdapter(madapter);

    }

    private  void createDots(int current_position)
    {
        if(Dots_Layout!=null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for(int i=0;i<layouts.length;i++)
        {
            dots[i] = new ImageView(this);
            if(i==current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,0,4,0);
            Dots_Layout.addView(dots[i],params);
        }
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_myacc: break;
            case R.id.nav_fav:
                Toast.makeText(this, "byeee", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_order:
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, MyOrders.class);
                startActivity(secondactivity1);

                break;

            case R.id.nav_cart:
                Intent secondactivity3 = new Intent();
                secondactivity3.setClass(logged_in.this, cart.class);
                startActivity(secondactivity3);

                break;
            case R.id.nav_aboutus:
                Intent secondactivity4 = new Intent();
                secondactivity4.setClass(logged_in.this, AboutUs.class);
                startActivity(secondactivity4);

                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }
}