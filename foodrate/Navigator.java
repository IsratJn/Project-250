package com.example.foodrate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageButton;
import android.widget.Toast;


public class Navigator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton burger,dessert,soup,chicken;
    private DrawerLayout drawer;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        burger=(ImageButton)findViewById(R.id.burger);
       // soup=(ImageButton)findViewById(R.id.soup);
       // dessert=(ImageButton)findViewById(R.id.dessert);
       // chicken=(ImageButton)findViewById(R.id.chicken);

        //burger.setOnClickListener(this);
        //soup.setOnClickListener(this);
        //dessert.setOnClickListener(this);
        //chicken.setOnClickListener(this);

      burger.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             Toast.makeText(Navigator.this,"Burger is clicked",Toast.LENGTH_LONG).show();
              //Intent intent = new Intent(Navigator.this,Burger.class);
              //startActivity(intent);
          }
      });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_feedback)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigator, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_feedback:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Feedback()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
