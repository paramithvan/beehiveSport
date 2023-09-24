package com.example.beehivesport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.beehivesport.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;
    Database database;

    EditText fullNam;
    EditText email_signUp;
    EditText password_signUp;
    EditText confirmPassword;

    Button signupBtn;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();


        database = new Database(this);

        fullNam = findViewById(R.id.fullName_edt_signUp);
        email_signUp = findViewById(R.id.email_edt_signup);
        password_signUp = findViewById(R.id.password_edt_signup);
        confirmPassword = findViewById(R.id.confirmpass_signup);
        signupBtn = findViewById(R.id.signup_btn_signup);
        login = findViewById(R.id.login_btn_signup);

       signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNam.getText().toString();
                String email = email_signUp.getText().toString();
                String password = password_signUp.getText().toString();
                String confirmPass = confirmPassword.getText().toString();

                if (fullName.isEmpty()|| email.isEmpty() || password.isEmpty() || confirmPass.isEmpty()){
                    Toast.makeText(SignUp.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirmPass)){
                        Boolean checkEmailUser = database.checkEmail(email);

                        if (checkEmailUser == false){
                            Boolean insert = database.insertData(fullName, email, password);

                            if(insert == true){
                                Toast.makeText(SignUp.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(SignUp.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUp.this, "User already exist, Please login", Toast.LENGTH_SHORT).show();
                        }

                    }

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}