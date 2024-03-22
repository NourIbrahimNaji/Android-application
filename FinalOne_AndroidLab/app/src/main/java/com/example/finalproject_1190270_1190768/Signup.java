package com.example.finalproject_1190270_1190768;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Signup extends AppCompatActivity {

    private EditText emailEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Spinner preferredDestinationSpinner;
    private Button signupButton;
    public static User myUser = new User();
    DataBaseHelper dataBaseHelper = new DataBaseHelper(Signup.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.basic)));
        emailEditText = findViewById(R.id.email);
        firstNameEditText = findViewById(R.id.FirstName);
        lastNameEditText = findViewById(R.id.lastName);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);
        preferredDestinationSpinner = findViewById(R.id.spinner2);
        signupButton = findViewById(R.id.signupButton);
        final Spinner preferredDestination = (Spinner) findViewById(R.id.spinner2);
        String[] semesterOption = {"Asia", "Europe", "Africa", "North America"};
        ArrayAdapter<String> courseSemesterArr = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semesterOption);
        preferredDestination.setAdapter(courseSemesterArr);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();
                String preferredDestination = preferredDestinationSpinner.getSelectedItem().toString();
                if (validateInput(email, firstName, lastName, password, confirmPassword)) {
                    myUser.setPtdestinations(preferredDestination);
                    dataBaseHelper.addUser(myUser);
                    dataBaseHelper.getCountryByContinent(DataBaseHelper.inputUser.getPtdestinations());
                } else {
                    Toast.makeText(Signup.this, "Invalid input. Please check your information.", Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView loginRedirectText = findViewById(R.id.loginRedirectText);
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateInput(String email, String firstName, String lastName, String password, String confirmPassword) {

        if (dataBaseHelper.checkEmailSignIn(email) == true) {
            Toast.makeText(Signup.this, "Input Email is used before , Please Enter another one..!!  ", Toast.LENGTH_LONG).show();
        } else {
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("");
                Toast.makeText(Signup.this, "Enter a valid email address", Toast.LENGTH_LONG).show();

                return false;
            } else {
                myUser.setUser_email(email);
            }
            if (firstName.isEmpty() || firstName.length() < 3 || firstName.length() > 20) {
                firstNameEditText.setError("");
                Toast.makeText(Signup.this, "Enter valid first name", Toast.LENGTH_LONG).show();
                return false;
            } else {
                myUser.setFist_name(firstName);
            }
            if (lastName.isEmpty() || lastName.length() < 3 || lastName.length() > 20) {
                lastNameEditText.setError("");
                Toast.makeText(Signup.this, "Enter valid Last name", Toast.LENGTH_LONG).show();
                return false;
            } else {
                myUser.setLast_name(lastName);
            }
            if (password.isEmpty() || password.length() < 8 || password.length() > 15) {
                passwordEditText.setError("");
                Toast.makeText(Signup.this, "Enter valid password", Toast.LENGTH_LONG).show();
                return false;
            }
            if (!password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
                passwordEditText.setError("");
                Toast.makeText(Signup.this, "Password must contain at least one uppercase letter and one number", Toast.LENGTH_LONG).show();
                return false;
            } else {
                myUser.setPassword(password);
            }
            if (!password.equals(confirmPassword)) {
                confirmPasswordEditText.setError("");
                Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                return false;
            } else {
                myUser.setCpassword(password);
            }
            Toast.makeText(Signup.this, "Save Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Signup.this, Part2.class);
            startActivity(intent);
        }
        return true;
    }
}
