package com.example.finalproject_1190270_1190768;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalproject_1190270_1190768.databinding.FragmentDesnameBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DesNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesNameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DesNameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PalestineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DesNameFragment newInstance(String param1, String param2) {
        DesNameFragment fragment = new DesNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }
    private  FragmentDesnameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDesnameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView_1 = binding.cityTextView;
        textView_1.setText(Part2.destinationName);
        return root;
    }
}