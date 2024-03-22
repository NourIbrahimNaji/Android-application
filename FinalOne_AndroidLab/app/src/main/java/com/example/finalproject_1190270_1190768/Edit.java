package com.example.finalproject_1190270_1190768;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finalproject_1190270_1190768.databinding.FragmentProfileBinding;
import com.example.finalproject_1190270_1190768.ui.profile.ProfileFragment;

public class Edit extends AppCompatActivity {
    private EditText emailEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText passwordEditText;
    private EditText password2;
    private Spinner preferredDestinationSpinner;
    private Button save;
    public static User EditUser = new User();
    DataBaseHelper dataBaseHelper = new DataBaseHelper(Edit.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final Spinner preferredDestination = (Spinner) findViewById(R.id.spinner);
        String[] semesterOption = {"Asia","Europe","Africa" , "North America"};
        ArrayAdapter<String> courseSemesterArr = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,semesterOption);
        preferredDestination.setAdapter(courseSemesterArr);

        firstNameEditText = findViewById(R.id.editUsername);
        lastNameEditText = findViewById(R.id.editUsername2);
        passwordEditText = findViewById(R.id.editPassword);
        password2 = findViewById(R.id.editPassword2);

        preferredDestinationSpinner = findViewById(R.id.spinner);
        save = findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String preferredDestination = preferredDestinationSpinner.getSelectedItem().toString();

                if (validateInput(firstName, lastName, password)) {
                    EditUser.setPtdestinations(preferredDestination);
                    EditUser.setUser_email(DataBaseHelper.inputUser.getUser_email());
                    EditUser.setCpassword(password2.getText().toString());
                    dataBaseHelper.updateUser(EditUser);
                    Intent intent = new Intent(Edit.this, Part2.class);
                    startActivity(intent);

                    Toast.makeText(Edit.this, "The update completed successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Edit.this, "Invalid input. Please check your information.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean validateInput(String firstName, String lastName, String password) {
        if (firstName.isEmpty() || firstName.length() < 3 || firstName.length() > 20) {
            firstNameEditText.setError("");
            Toast.makeText(Edit.this, "Enter valid first name", Toast.LENGTH_LONG).show();
            return false;
        }else{
            EditUser.setFist_name(firstName);
        }
        if (lastName.isEmpty() || lastName.length() < 3 || lastName.length()  >20){
            lastNameEditText.setError("");
            Toast.makeText(Edit.this, "Enter valid Last name", Toast.LENGTH_LONG).show();
            return false;
        }else{
            EditUser.setLast_name(lastName);
        }
        if (password.isEmpty() || password.length() < 8 || password.length() > 15) {
            passwordEditText.setError("");
            Toast.makeText(Edit.this, "Enter valid password", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!password.matches(".[A-Z].") || !password.matches(".[0-9].")) {
            passwordEditText.setError("");
            Toast.makeText(Edit.this, "Password must contain at least one uppercase letter and one number", Toast.LENGTH_LONG).show();
            return false;
        }else{
            EditUser.setPassword(password);
        }
        return true;
    }
}