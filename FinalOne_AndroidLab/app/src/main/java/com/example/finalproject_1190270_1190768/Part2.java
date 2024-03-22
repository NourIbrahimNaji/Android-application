package com.example.finalproject_1190270_1190768;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.example.finalproject_1190270_1190768.ui.all.AllFragment;
import com.example.finalproject_1190270_1190768.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject_1190270_1190768.databinding.ActivityPart2Binding;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityPart2Binding binding;
    // favorite destination list
    public static List<Destination> favoritedDestinationList = new ArrayList<>();
    // all destinations..
    public static List<Destination> allDesList = new ArrayList<>();
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    // destination name to put it in destination name fragment.
    public static String destinationName;
    public static List<Destination> allASEOrder = new ArrayList<>();
    public static List<Destination> allDESOrder = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPart2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBaseHelper.getAllInfo();
        dataBaseHelper.DecendingOrder();
        dataBaseHelper.AscendingOrder();
        setSupportActionBar(binding.appBarPart2.toolbar);
        binding.appBarPart2.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_all, R.id.nav_favorite, R.id.nav_sorted, R.id.nav_profile, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_part2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.part2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_part2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            //Intent intent = new Intent(Part2.this , HomeFragment.class);
            //startActivity(intent);
        } else if (id == R.id.nav_all) {
            // Intent intent = new Intent(Part2.this , AllFragment.class);
            //startActivity(intent);
        } else if (id == R.id.nav_logout) {
            logoutmenu(Part2.this);
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logoutmenu(Part2 log_out) {
        AlertDialog.Builder builder = new AlertDialog.Builder(log_out);
        builder.setTitle("Logout");
        builder.setMessage("Are You Sure ??");
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //finish();
                Intent intent2 = new Intent(Part2.this, Login.class);
                startActivity(intent2);
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}