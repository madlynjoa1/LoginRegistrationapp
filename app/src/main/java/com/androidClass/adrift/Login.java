package com.androidClass.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLoginActi;
    TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername=(EditText)findViewById(R.id.usernameET);
        editTextPassword= (EditText)findViewById(R.id.passwordET);
        buttonLoginActi= (Button)findViewById(R.id.buttonLoginAct);
        textViewRegister=(TextView)findViewById(R.id.registerLoginAct);

        buttonLoginActi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we are checking if our fields our empty when we click the login button
                if(TextUtils.isEmpty(editTextUsername.getText().toString()) || TextUtils.isEmpty(editTextPassword.getText().toString())){
                    Toast.makeText(Login.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    //if not emty eneter to app
                    Intent intent = new Intent(Login.this,WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });
//We have a button to direct us to the register activity page
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent= new Intent(Login.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

    }
}