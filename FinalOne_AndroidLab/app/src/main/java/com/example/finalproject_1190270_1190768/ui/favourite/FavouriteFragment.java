package com.example.finalproject_1190270_1190768.ui.favourite;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.finalproject_1190270_1190768.DataBaseHelper;
import com.example.finalproject_1190270_1190768.Part2;
import com.example.finalproject_1190270_1190768.R;
import com.example.finalproject_1190270_1190768.databinding.FragmentFavoriteBinding;
import com.example.finalproject_1190270_1190768.ui.home.HomeViewModel;
import com.squareup.picasso.Picasso;

import java.io.StringWriter;

public class FavouriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentFavoriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // text view to show destination information
        final TextView textViewCity = binding.textView6;
        StringWriter sw = new StringWriter();
        for (int i = 0 ;i < Part2.favoritedDestinationList.size();i++) {
            sw.append(" City: " + Part2.favoritedDestinationList.get(i).getCity() + "       Country: " + Part2.favoritedDestinationList.get(i).getCountry() + "\n");
        }
        textViewCity.setText(sw.toString());
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
