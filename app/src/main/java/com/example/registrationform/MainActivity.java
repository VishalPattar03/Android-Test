package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextPassword, editTextConfirmPassword;
    private ProgressBar progressBar;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        progressBar = findViewById(R.id.progressBar);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        submitButton = findViewById(R.id.submitButton);

        // Set text watchers
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateProgressBar();
            }
        };
        submitButton.setOnClickListener(v -> {
            // Navigate to ThankYouActivity
            Intent intent = new Intent(MainActivity.this, SuccesActivity.class);
            startActivity(intent);
        });

        // Add TextWatcher to all fields
        editTextName.addTextChangedListener(textWatcher);
        editTextEmail.addTextChangedListener(textWatcher);
        editTextPhone.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);
        editTextConfirmPassword.addTextChangedListener(textWatcher);
    }

    // Method to update progress bar and enable button
    private void updateProgressBar()
    {

        int progress = 0;
        if (!editTextName.getText().toString().trim().isEmpty()) { progress += 20; }
        if (!editTextEmail.getText().toString().trim().isEmpty()) { progress+=20; }
        if (!editTextPhone.getText().toString().trim().isEmpty()) { progress+=20; }
        if (!editTextPassword.getText().toString().trim().isEmpty()) { progress+=20; }
        if (!editTextConfirmPassword.getText().toString().trim().isEmpty()) { progress+=20; }
        progressBar.setProgress(progress);

        // Enable the button when all fileds are fill
        if (progress == 100)
        {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }
}
