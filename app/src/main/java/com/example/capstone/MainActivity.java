package com.example.capstone;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        /* toolbar.setTitleTextAppearance(this, R.style.comfortaaTextAppearance);

        TextView textCustomTitle = (TextView) findViewById(R.id.custom_title);

        // Custom font
        Typeface customFont = Typeface.createFromAsset(this.getAssets(), "@font/comfortaa_regular.tff");

        // Set
        textCustomTitle.setTypeface(customFont);

        setSupportActionBar(toolbar);

        */

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchToChat = new Intent(MainActivity.this, SimpleChat.class);
                MainActivity.this.startActivity(switchToChat);
            }
        });

        Button chatChange = findViewById(R.id.active_chat);
        chatChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchToChat = new Intent(MainActivity.this, SimpleChat.class);
                MainActivity.this.startActivity(switchToChat);
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




    }

    public void OpenSimpleChat(View view) {
                Intent switchToChat = new Intent(MainActivity.this, SimpleChat.class);
                MainActivity.this.startActivity(switchToChat);
            }



    public void SettingsTest(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {
            Intent switchToSettings = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(switchToSettings);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}