package com.androidClass.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class RegisterActivity extends AppCompatActivity {
    //declase our elements used
    EditText usernameRegET;
    EditText firstNameET;
    EditText lastNameET;
    EditText dateOfBirthET;
    EditText emailET;
    EditText passwordET;
    EditText confirmPassET;
    Button registerRegAct;
    TextView loginReAct;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       awesomeValidation = new AwesomeValidation(BASIC);

        //sync our View with Model
        usernameRegET= (EditText)findViewById(R.id.usernameET);
        firstNameET=(EditText)findViewById(R.id.firstName);
        lastNameET=(EditText)findViewById(R.id.lastName);
        dateOfBirthET=(EditText)findViewById(R.id.dateOfBirth);
        emailET=(EditText)findViewById(R.id.email);
        passwordET=(EditText)findViewById(R.id.passwordET);
        confirmPassET=(EditText)findViewById(R.id.confirmPasswordET);
        registerRegAct=(Button)findViewById(R.id.registerRegAct);
        loginReAct=(TextView)findViewById(R.id.loginRegAct);

        awesomeValidation.addValidation(RegisterActivity.this, R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(RegisterActivity.this, R.id.firstName, "[a-zA-Z\\s]{3,}", R.string.err_name);

        registerRegAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We check if our fields our emty
                if(TextUtils.isEmpty(firstNameET.getText().toString()) || TextUtils.isEmpty(lastNameET.getText().toString()) ||
                        TextUtils.isEmpty(emailET.getText().toString()) || TextUtils.isEmpty(dateOfBirthET.getText().toString()) ||
                        TextUtils.isEmpty(usernameRegET.getText().toString()) || TextUtils.isEmpty(passwordET.getText().toString()) ||
                        TextUtils.isEmpty(confirmPassET.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    //validate if our email is correct and if our name has more than 3 letters
                    if (awesomeValidation.validate()) {
                        //get user input to strings
                        String nameCheck = firstNameET.getText().toString();
                        String emailCheck = emailET.getText().toString();
                        //if email and name our correct than create a login and direct to Login page
                        Toast.makeText(getApplicationContext(), "created", Toast.LENGTH_LONG).show();
                        Intent registerRegIntent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(registerRegIntent);
                    } else {
                        //if email and name incorect display invalid
                        Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        //text view that directs you to login activity page
        loginReAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(RegisterActivity.this,Login.class);
                startActivity(loginIntent);
            }
        });





    }
}