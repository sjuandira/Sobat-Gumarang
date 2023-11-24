package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class searchTiket extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tiket);
        loadFragment(new Home_fragment_st());
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }
    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment).commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        Fragment fragment=null;
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment=new Home_fragment_st();
                break;
            case R.id.profil:
                fragment=new ProfileFragment();
                break;
            case R.id.nav_booking:
                fragment=new booking_fragment();
                break;
        }
        Bundle bundle=new Bundle();
        if (getIntent().getSerializableExtra("transaksi")!=null){
            transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
            bundle.putSerializable("transaksi",x);
            fragment.setArguments(bundle);
        }
        return loadFragment(fragment);
    }
    public void gotoListTiket(View view){
        EditText asal=findViewById(R.id.asal);
        EditText tujuan=findViewById(R.id.tujuan);
        EditText keberangkatan=findViewById(R.id.tgl_brkt);
        EditText penumpang=findViewById(R.id.penumpang);

        Intent intent=new Intent(this,listTiket.class);

        if(asal.getText().toString().isEmpty() || tujuan.getText().toString().isEmpty()||keberangkatan.getText().toString().isEmpty()||penumpang.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill the form", Toast.LENGTH_SHORT).show();
        }else{
            transaksi x=new transaksi();
            x.setAsal(asal.getText().toString());
            x.setTujuan(tujuan.getText().toString());
            intent.putExtra("transaksi",x);
            startActivity(intent);
        }
    }
    public void gotoDetailTiket(View view){
        Intent intent=new Intent(this,detailTiket.class);
        if (getIntent().getSerializableExtra("transaksi")!=null){
            transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
            intent.putExtra("transaksi",x);
        }
        startActivity(intent);
    }
}