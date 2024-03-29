package com.example.wastemanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity2 extends AppCompatActivity {

    private EditText adminEmail, adminPass;
    FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        
        adminEmail=findViewById(R.id.adminEmail);
        adminPass=findViewById(R.id.adminPass);
        Button adminLogBtn = findViewById(R.id.adminLogBtn);
        adminLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adminEmail.getText().toString().equals("admin@nitc.ac.in") && adminPass.getText().toString().equals("admin123")){
                    Toast.makeText(AdminActivity2.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminActivity2.this,AdminDashboardPage.class ));
                }
                else{
                    Toast.makeText(AdminActivity2.this, "Login Failed! Enter Email and Password Correctly!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}