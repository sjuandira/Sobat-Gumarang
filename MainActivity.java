package com.salju.sobatgumarang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView= findViewById(R.id.bar_bawah);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment= null;
                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment= new HomeFragment();
                        break;
                    case R.id.tiket:
                        selectedFragment= new TiketFragment();
                        break;
                    case R.id.profile:
                        selectedFragment= new ProfileFragment();
                        break

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment). commit();
                return true;
            }
        });
    }
}
