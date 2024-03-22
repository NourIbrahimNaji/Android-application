package com.example.finalproject_1190270_1190768.ui.sorted;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.finalproject_1190270_1190768.Part2;
import com.example.finalproject_1190270_1190768.R;
import com.example.finalproject_1190270_1190768.databinding.FragmentSortedBinding;

import java.io.StringWriter;

public class SortedFragment extends Fragment {
    private FragmentSortedBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSortedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button ASC = (Button)root.findViewById(R.id.ascendingorder);
        Button DES = (Button)root.findViewById(R.id.descendingorder);
        final ImageView imageView = (ImageView)root.findViewById(R.id.imageView4);
        final TextView textView_1 = binding.textView13;
        StringWriter sw_1 = new StringWriter();
        StringWriter sw_2 = new StringWriter();

        Toast.makeText(getActivity(), "Press one of the two buttons to sort in ascending or descending order", Toast.LENGTH_LONG).show();
        ASC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_1.setText(" ");
                sw_1.getBuffer().setLength(0);
                for(int i = 0 ; i < Part2.allASEOrder.size();i++)
                {
                    sw_1.append(Part2.allASEOrder.get(i).getCity() +   "            " +
                            Part2.allASEOrder.get(i).getCost() +"\n");
                }
                textView_1.setText(sw_1.toString());
                imageView.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.asceding));
            }
        });
        DES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_1.setText(" ");
                sw_2.getBuffer().setLength(0);
                for(int i = 0 ; i < Part2.allDESOrder.size();i++)
                {
                    sw_2.append(Part2.allDESOrder.get(i).getCity() +   "            " +
                            Part2.allDESOrder.get(i).getCost() +"\n");
                }
                textView_1.setText(sw_2.toString());
                imageView.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.descending));

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
