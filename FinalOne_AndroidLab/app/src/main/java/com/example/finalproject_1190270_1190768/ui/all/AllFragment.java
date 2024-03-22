package com.example.finalproject_1190270_1190768.ui.all;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalproject_1190270_1190768.DataBaseHelper;
import com.example.finalproject_1190270_1190768.DestinationActivity;
import com.example.finalproject_1190270_1190768.Part2;
import com.example.finalproject_1190270_1190768.databinding.FragmentAllBinding;

import java.io.StringWriter;

import android.content.Intent;
import android.widget.Toast;


public class AllFragment extends Fragment {

    private FragmentAllBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAllBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this.getActivity());

        final TextView textView_1 = binding.result1;
        final TextView textView_2 = binding.result2;
        final TextView textView_3 = binding.result3;
        final TextView textView_4 = binding.result4;
        final TextView textView_5 = binding.result5;
        final TextView textView_6 = binding.result6;
        final TextView textView_7 = binding.result7;
        final TextView textView_8 = binding.result8;

        StringWriter sw_1 = new StringWriter();
        StringWriter sw_2 = new StringWriter();
        StringWriter sw_3 = new StringWriter();
        StringWriter sw_4 = new StringWriter();
        StringWriter sw_5 = new StringWriter();
        StringWriter sw_6 = new StringWriter();
        StringWriter sw_7 = new StringWriter();
        StringWriter sw_8 = new StringWriter();


        sw_1.append(Part2.allDesList.get(3).getCity() + "\n " + Part2.allDesList.get(3).getCountry());
        sw_2.append(Part2.allDesList.get(2).getCity() + " \n " + Part2.allDesList.get(2).getCountry());
        sw_3.append(Part2.allDesList.get(4).getCity() + " \n " + Part2.allDesList.get(4).getCountry());
        sw_4.append(Part2.allDesList.get(5).getCity() + " \n " + Part2.allDesList.get(5).getCountry());
        sw_5.append(Part2.allDesList.get(0).getCity() + " \n " + Part2.allDesList.get(0).getCountry());
        sw_6.append(Part2.allDesList.get(1).getCity() + " \n " + Part2.allDesList.get(1).getCountry());
        sw_7.append(Part2.allDesList.get(6).getCity() + " \n " + Part2.allDesList.get(6).getCountry());
        sw_8.append(Part2.allDesList.get(7).getCity() + " \n " + Part2.allDesList.get(7).getCountry());
        textView_1.setText(sw_1.toString());
        textView_2.setText(sw_2.toString());
        textView_3.setText(sw_3.toString());
        textView_4.setText(sw_4.toString());
        textView_5.setText(sw_5.toString());
        textView_6.setText(sw_6.toString());
        textView_7.setText(sw_7.toString());
        textView_8.setText(sw_8.toString());

        textView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("Seoul");
                Part2.destinationName = "Seoul";
                dataBaseHelper.findImageDescription("Seoul");

                dataBaseHelper.allInfo("Seoul");
                Intent intent = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent);
            }
        });
        textView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("Jerusalem");
                Part2.destinationName = "Jerusalem";
                dataBaseHelper.findImageDescription("Jerusalem");
                dataBaseHelper.allInfo("Jerusalem");
                Intent intent = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent);
            }
        });
        textView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("London");
                Part2.destinationName = "London";
                dataBaseHelper.findImageDescription("London");
                dataBaseHelper.allInfo("London");
                Intent intent = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent);
            }
        });
        textView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("Paris");
                Part2.destinationName = "Paris";
                dataBaseHelper.findImageDescription("Paris");
                dataBaseHelper.allInfo("Paris");
                Intent intent2 = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent2);
            }
        });
        textView_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("Addis Ababa");
                Part2.destinationName = "Addis Ababa";
                dataBaseHelper.findImageDescription("Addis Ababa");
                dataBaseHelper.allInfo("Addis Ababa");
                Intent intent2 = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent2);
            }
        });
        textView_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("Cairo");
                Part2.destinationName = "Cairo";
                dataBaseHelper.findImageDescription("Cairo");
                dataBaseHelper.allInfo("Cairo");
                Intent intent2 = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent2);
            }
        });
        textView_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("Los Angeles");
                Part2.destinationName = "Los Angeles";
                dataBaseHelper.findImageDescription("Los Angeles");
                dataBaseHelper.allInfo("Los Angeles");
                Intent intent2 = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent2);
            }
        });
        textView_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.findCityDescription("New York");
                Part2.destinationName = "New York";
                dataBaseHelper.findImageDescription("New York");
                dataBaseHelper.allInfo("New York");
                Intent intent2 = new Intent(getActivity(), DestinationActivity.class);
                startActivity(intent2);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}