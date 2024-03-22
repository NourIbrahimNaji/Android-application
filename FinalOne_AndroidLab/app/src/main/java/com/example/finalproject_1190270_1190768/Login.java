package com.example.finalproject_1190270_1190768;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.basic)));
        Button signin = (Button) findViewById(R.id.signInBtn2);
        // define the plain texts to get the user email and password.
        EditText emailEditText = (EditText) findViewById(R.id.email_input);
        EditText passwordEditText = (EditText) findViewById(R.id.password_input);
        // define the check box.
        CheckBox rememberMeCheckBox = (CheckBox) findViewById(R.id.rememberMeCheckBox);
        // Check for saved email in shared preferences
        SharedPrefManager prefs = SharedPrefManager.getInstance(this);
        String savedEmail = prefs.readString("email", "");
        emailEditText.setText(savedEmail);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Verify email and password against database
                // If match, proceed to next activity and save email in shared preferences if "remember me" is checked
                DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                if (dataBaseHelper.checkEmailSignIn(email) == true) {
                    if (dataBaseHelper.checkEmailPassword(email, password) == true) {
                        if (rememberMeCheckBox.isChecked()) {
                            prefs.writeString("email", email);
                        }

                        dataBaseHelper.getCountryByContinent(DataBaseHelper.inputUser.getPtdestinations());
                        System.out.println("city" + DataBaseHelper.homeDes.getCity());
                        Intent intent2 = new Intent(Login.this, Part2.class);
                        startActivity(intent2);
                    } else if (dataBaseHelper.checkEmailPassword(email, password) == false) {
                        Toast.makeText(Login.this, "Invalid password", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Invalid email", Toast.LENGTH_LONG).show();
                }
            }
        });
        TextView signupRedirectText = findViewById(R.id.signupRedirectText);

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

    }
}