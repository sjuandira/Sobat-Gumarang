package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PilihBank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bank);
    }
    public void gotoPembayaran(View view){
        transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
        Intent intent=new Intent(this,Pembayaran.class);
        intent.putExtra("transaksi",x);
        startActivity(intent);
    }
}