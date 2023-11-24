package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void gotologin(View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public void gotoSignUp(View view){
        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
    }
}