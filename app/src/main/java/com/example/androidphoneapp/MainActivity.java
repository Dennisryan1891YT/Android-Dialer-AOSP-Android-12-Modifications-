package com.example.androidphoneapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String input = phoneNumberInput.getText().toString().trim();

            if (TextUtils.isEmpty(input)) {
                Toast.makeText(this, "Phone number cannot be empty.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!PhoneNumberValidator.isValidCustomPhoneNumber(input)) {
                Toast.makeText(this,
                        "Emergency numbers like 911 or 999 are not allowed as custom phone numbers.",
                        Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(this, "Phone number accepted.", Toast.LENGTH_SHORT).show();
        });
    }
}
