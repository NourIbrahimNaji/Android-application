package com.example.finalproject_1190270_1190768.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.finalproject_1190270_1190768.DataBaseHelper;
import com.example.finalproject_1190270_1190768.Part2;
import com.example.finalproject_1190270_1190768.R;
import com.example.finalproject_1190270_1190768.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // text view to show country information
        final TextView textView = binding.textView5;
        // to show country image
        final ImageView  imageView= binding.imageView2;
        Picasso.get().load(DataBaseHelper.homeDes.getImage()).into(imageView);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        // favorite button..
        Button favBtn = binding.favButton;
        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Part2.favoritedDestinationList.contains(DataBaseHelper.homeDes)){
                    Part2.favoritedDestinationList.remove(DataBaseHelper.homeDes);
                    favBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    Toast.makeText(getActivity(), "remove from favorite list ", Toast.LENGTH_LONG).show();
                    //System.out.println("The destination is already in your favorite list!");
                }else{
                    Part2.favoritedDestinationList.add(DataBaseHelper.homeDes);
                    favBtn.setBackgroundColor(getResources().getColor(R.color.basic));
                    Toast.makeText(getActivity(), "add to favorite list ", Toast.LENGTH_LONG).show();

                }
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