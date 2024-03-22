package com.example.finalproject_1190270_1190768;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.basic)));
        Button signin = (Button) findViewById(R.id.button7);
        Button login = (Button) findViewById(R.id.button8);
        // make the connection to api
        ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(MainActivity.this);
        connectionAsyncTask.execute("https://run.mocky.io/v3/d1a9c002-6e88-4d1e-9f39-930615876bca");
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);

            }
        });

    }

    // to get data read from api, and store it in the database
    public void addToDataBase(List<Destination> destinationList) {
        dataBaseHelper.deleteExistsDes();
        for (int i = 0; i < destinationList.size(); i++) {
            dataBaseHelper.addDestination(destinationList.get(i));
        }
    }

}