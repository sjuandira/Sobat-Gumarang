package com.naufalhilal.SoGu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class identidasPenumpang extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identidas_penumpang);
        loadFragment(new home_ip_Fragment());
//        BottomNavigationView bottomNavigationView=findViewById(R.id.fragment_container);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(home_ip_Fragment Fragment) {
        if (Fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,Fragment).commit();
            return true;
        }
        return false;
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        home_ip_Fragment fragment=null;
//        switch (item.getItemId()){
//            case R.id.nav_home:
//                fragment=new home_ip_Fragment();
//                break;
//            case R.id.profil:
//                fragment=new home_ip_Fragment();
//                break;
//        }
//        return loadFragment(fragment);
//    }
    public void gotoPilihKursi(View view){
        EditText etNama=findViewById(R.id.editTextTextPersonName);
        EditText etNik=findViewById(R.id.editTextTextPersonNik);
        EditText etEmail=findViewById(R.id.editTextTextPersonEmail);
        EditText etNoTelp=findViewById(R.id.editTextTextPersonHp);
        String nama=etNama.getText().toString();
        String nik=etNik.getText().toString();
        String email=etEmail.getText().toString();
        String hp=etNoTelp.getText().toString();
        Intent intent=new Intent(this,PilihKursi.class);
        transaksi x=new transaksi();
        x.setAsal(getIntent().getStringExtra("kota_asal"));
        x.setJam_brkt(getIntent().getStringExtra("jam_brkt"));
        x.setTgl_brkt(getIntent().getStringExtra("tgl_brkt"));
        x.setHarga(getIntent().getStringExtra("harga"));
        x.setTujuan(getIntent().getStringExtra("kota_tujuan"));
        x.setJam_sampai(getIntent().getStringExtra("jam_sampai"));
        x.setTgl_sampai(getIntent().getStringExtra("tgl_sampai"));
        x.setNama(nama);
        x.setNik(nik);
        intent.putExtra("transaksi",x);

        boolean isEmptyFields=false;
        if (TextUtils.isEmpty(nama)){
            isEmptyFields=true;
            etNama.setError("field ini harus diisi");
        }
        if (TextUtils.isEmpty(nik)){
            isEmptyFields=true;
            etNik.setError("field ini harus diisi");
        }
        if (TextUtils.isEmpty(email)){
            isEmptyFields=true;
            etEmail.setError("field ini harus diisi");
        }
        if (TextUtils.isEmpty(hp)){
            isEmptyFields=true;
            etNoTelp.setError("field ini harus diisi");
        }
        if (!isEmptyFields){
            startActivity(intent);
        }
    }
}