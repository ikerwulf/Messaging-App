package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import com.example.capstone.ui.AddingDialog;
import com.example.capstone.ui.ContactsAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements AddingDialog.ContactDialogListener {

    private AppBarConfiguration mAppBarConfiguration;
    RecyclerView recyclerView;
    ArrayList<ContactModel> contactsList = new ArrayList<>(2);

    private TextView textContactAdded;
    private Button addContactButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        ContactsAdapter adapter = new ContactsAdapter(this, contactsList);
        recyclerView = findViewById(R.id.recycler_view_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);





        addContactButton = (Button) findViewById(R.id.addbutton);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });






        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
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

    public void openSimpleChat(View view) {
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
    public void openDialog() {
        AddingDialog addDialog = new AddingDialog();
        addDialog.show(getSupportFragmentManager(), "Adding Contact");
    }

    public void applyTexts(String userContact) {
        textContactAdded.setText(userContact);
    }

}