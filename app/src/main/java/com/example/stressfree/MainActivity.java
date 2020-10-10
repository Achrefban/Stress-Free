package com.example.stressfree;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

   Toolbar toolbar,toolbartab;
   ViewPager viewpager;
   TabLayout tabLayout;
   PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbartab = (Toolbar) findViewById(R.id.toolbartab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        setSupportActionBar(toolbar);


        pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new RedFragment(), "Red");
        pageAdapter.addFragment(new BlueFragment(), "Blue");
        pageAdapter.addFragment(new GreenFragment(), "Green");

        viewpager.setAdapter(pageAdapter);



        tabLayout.setupWithViewPager(viewpager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                            getWindow().setStatusBarColor(Color.RED);
                            toolbar.setBackgroundColor(Color.RED);
                            toolbartab.setBackgroundColor(Color.RED);
                            tabLayout.setBackgroundColor(Color.RED);
                    break;
                    case 2:
                        getWindow().setStatusBarColor(Color.GREEN);
                        toolbar.setBackgroundColor(Color.GREEN);
                        toolbartab.setBackgroundColor(Color.GREEN);
                        tabLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case 1:
                        getWindow().setStatusBarColor(Color.BLUE);
                        toolbar.setBackgroundColor(Color.BLUE);
                        toolbartab.setBackgroundColor(Color.BLUE);
                        tabLayout.setBackgroundColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}