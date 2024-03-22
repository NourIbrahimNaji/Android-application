package com.example.finalproject_1190270_1190768.ui.profile;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalproject_1190270_1190768.DataBaseHelper;
import com.example.finalproject_1190270_1190768.Edit;
import com.example.finalproject_1190270_1190768.R;
import com.example.finalproject_1190270_1190768.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    TextView profileFirstName,profileLastName, profileEmail, profilePassword , profilePreferd ;
    TextView titleName;
    Button editProfile;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        profileFirstName = root.findViewById(R.id.profileFirst);
        profileLastName = root.findViewById(R.id.profilelast);
        profileEmail = root.findViewById(R.id.profileEmail);
        profilePassword = root.findViewById(R.id.profilePassword);
        profilePreferd = root.findViewById(R.id.profilePreferd);
        titleName = root.findViewById(R.id.titleName);
        editProfile = root.findViewById(R.id.editButton);

        showUserData();

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Edit.class);
                startActivity(intent);
            }
        });

        return root;
    }

    private void passUserData() {


    }

    private void showUserData() {
        profileFirstName.setText(DataBaseHelper.inputUser.getFist_name());
        titleName.setText(DataBaseHelper.inputUser.getFist_name());
        profileLastName.setText(DataBaseHelper.inputUser.getLast_name());
        profileEmail.setText(DataBaseHelper.inputUser.getUser_email());
        profilePassword.setText(DataBaseHelper.inputUser.getPassword());
        profilePreferd.setText(DataBaseHelper.inputUser.getPtdestinations());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
