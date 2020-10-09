package com.androidClass.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public Button button;
    public Button registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.login);
        registerButton=(Button)findViewById(R.id.registerMain);
//We have login button will direct us to login page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Login.class);// specify name first activity and then snd acti
                startActivity(intent);//call the obj
            }
        });
        //register button direct us to register activity
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentReg);
            }
        });


    }
}