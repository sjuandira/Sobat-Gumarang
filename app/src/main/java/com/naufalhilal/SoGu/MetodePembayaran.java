package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MetodePembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_pembayaran);

    }
    public void gotoPilihBank(View view){
        transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
        Intent intent=new Intent(this,PilihBank.class);
        intent.putExtra("transaksi",x);
        startActivity(intent);
    }
}