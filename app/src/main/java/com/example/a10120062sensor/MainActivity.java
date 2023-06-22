package com.example.a10120062sensor;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.a10120062sensor.adapter.AdapterViewPager;
import com.example.a10120062sensor.fragment.homeFragment;
import com.example.a10120062sensor.fragment.profilFragment;
import com.example.a10120062sensor.fragment.locationFragment;
import com.example.a10120062sensor.fragment.mapsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
/**
 * 10120062
 * Ahmad Sanosi
 * IF-2
 */
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    ViewPager2 vp;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.view_pager);
        bnv = findViewById(R.id.b_nav);

        fragmentArrayList.add(new homeFragment());
        fragmentArrayList.add(new mapsFragment());
        fragmentArrayList.add(new locationFragment());
        fragmentArrayList.add(new profilFragment());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        // set adapter

        vp.setAdapter(adapterViewPager);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 0:
                        bnv.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bnv.setSelectedItemId(R.id.maps);
                        break;
                    case 2:
                        bnv.setSelectedItemId(R.id.location);
                        break;
                    case 3:
                        bnv.setSelectedItemId(R.id.profil);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bnv.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                vp.setCurrentItem(0);
            } else if (itemId == R.id.maps) {
                vp.setCurrentItem(1);
            } else if (itemId == R.id.location) {
                vp.setCurrentItem(2);
            } else if (itemId == R.id.profil) {
                vp.setCurrentItem(3);
            }
            return true;
        });
    }
}