package com.example.finalproject_1190270_1190768.ui.Logout;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.finalproject_1190270_1190768.Login;
import com.example.finalproject_1190270_1190768.Part2;
import com.example.finalproject_1190270_1190768.R;
import com.example.finalproject_1190270_1190768.databinding.FragmentLogoutBinding;


public class LogoutFragment extends Fragment {

    private FragmentLogoutBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentLogoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button logout = (Button)root.findViewById(R.id.button2);
        Button cancel = (Button)root.findViewById(R.id.button3);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Part2.class);
                startActivity(intent);
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
