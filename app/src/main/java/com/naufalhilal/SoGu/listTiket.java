package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class listTiket extends AppCompatActivity {

    Fragment fragment=new HomeFragment();
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tiket);
        Bundle bundle=new Bundle();
        if (getIntent().getSerializableExtra("transaksi")!=null){
            transaksi x=(transaksi) getIntent().getSerializableExtra("transaksi");
            bundle.putSerializable("transaksi",x);
            fragment.setArguments(bundle);
        }
        loadFragment(fragment);
//        BottomNavigationView bottomNavigationView=findViewById(R.id.fragment_container);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }
    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,fragment).commit();
            return true;
        }
        return false;
    }
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item){
//        Fragment fragment=null;
//        switch (item.getItemId()){
//            case R.id.nav_home:
//                fragment=new HomeFragment();
//                break;
//            case R.id.profil:
//                fragment=new ProfileFragment();
//                break;
//        }
//        return loadFragment(fragment);
//    }
}