package com.example.beehivesport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.beehivesport.data.ScheduleData;
import com.example.beehivesport.data.UserData;
import com.example.beehivesport.databinding.ActivitySignUpBinding;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText email_login;
    EditText pass_login;
    Button login;
    Button signup;

    ActivitySignUpBinding binding;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login2);
        database = new Database(this);

        email_login = findViewById(R.id.email_edt_login);
        pass_login = findViewById(R.id.password_edt_login);
        login = findViewById(R.id.login_btn_login);
        signup = findViewById(R.id.signUp_btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = email_login.getText().toString();
                String getPassword = pass_login.getText().toString();
                if (getEmail.isEmpty() ||getPassword.isEmpty()){
                    Toast.makeText(Login.this, "Please fill out the required fields", Toast.LENGTH_SHORT).show();
                }else{
                        Boolean checkAkun = database.checkLogin(getEmail, getPassword);

                        if (checkAkun == true){
                            Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "You cannot login without a registered account", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });

        binding.signupBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}