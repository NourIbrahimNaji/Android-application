package com.example.finalproject_1190270_1190768;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DestinationActivity extends AppCompatActivity {
    int clickCountNum=0;
    int clickCountNum1=0;
    int clickCountNum2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jerusalem);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.basic)));
        Button buttonDescription = findViewById(R.id.Desc);
        Button buttonImage = findViewById(R.id.Image);
        Button buttonLocation = findViewById(R.id.Location);
        Button addFav = (Button) findViewById(R.id.addToFav);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final DescriptionFragment descriptionFragment = new DescriptionFragment();
        final ImageFragment imageFragment = new ImageFragment();
        final LocationFragment locationFragment = new LocationFragment();

        // when description button in clicked
        buttonDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCountNum++;
                if (clickCountNum == 1) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.root_layout, descriptionFragment, "Description Fragment");
                    fragmentTransaction.commit();
                } else if (clickCountNum == 2) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(descriptionFragment);
                    fragmentTransaction.commit();
                    clickCountNum = 0;
                }

            }
        });
        // when image button in clicked
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickCountNum1++;
                if (clickCountNum1 == 1) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.root_layout, imageFragment, "Image Fragment");
                    fragmentTransaction.commit();
                } else if (clickCountNum1 == 2) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(imageFragment);
                    fragmentTransaction.commit();
                    clickCountNum1 = 0;
                }

            }
        });
        // when location button in clicked
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCountNum2++;
                if (clickCountNum2 == 1) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.root_layout,locationFragment , "Image Fragment");
                    fragmentTransaction.commit();
                } else if (clickCountNum2 == 2) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(locationFragment);
                    fragmentTransaction.commit();
                    clickCountNum2 = 0;
                }
            }
        });

        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Part2.favoritedDestinationList.contains(DataBaseHelper.favDes)){
                    Part2.favoritedDestinationList.remove(DataBaseHelper.favDes);
                    addFav.setBackgroundColor(getResources().getColor(R.color.grey));
                    Toast.makeText(DestinationActivity.this, "remove from favorite list ", Toast.LENGTH_LONG).show();
                }else{
                    Part2.favoritedDestinationList.add(DataBaseHelper.favDes);
                    addFav.setBackgroundColor(getResources().getColor(R.color.basic));
                    Toast.makeText(DestinationActivity.this, "add to favorite list ", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}