package com.example.ticketmovie.movieapp.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ViewCinemaTicket;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    View mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        anhxa();

        ViewCinemaTicket viewBacSiAdapter =new ViewCinemaTicket(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewBacSiAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.trangchu).setChecked(true);
                        break;
                    case 1:
                            bottomNavigationView.getMenu().findItem(R.id.veluu).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.user).setChecked(true);

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trangchu:
                        viewPager.setCurrentItem(0);

                        break;
                    case R.id.veluu:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.user:

                        viewPager.setCurrentItem(2);

                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();


    }

    private void anhxa() {
        viewPager =findViewById(R.id.view_pager);
        bottomNavigationView=findViewById(R.id.bottom_navi);
    }
    }
