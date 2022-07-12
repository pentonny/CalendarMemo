package com.example.calendarmemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private AppCompatActivity binding;
    public CalendarView calendarView;
    MainHome mainHome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainHome = new MainHome();
        //calendarView = findViewById(R.id.CalendarView);

        //FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.home_ly, fragmentCalendar).commitAllowingStateLoss();

        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new MainHome()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homeB:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new MainHome()).commit();
                        //transaction.replace(R.id.home_ly,fragmentHome).commitAllowingStateLoss();
                        break;
                    case R.id.item1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new DiaryViewFragment()).commit();
                        //transaction.replace(R.id.nav_view,fragmentDiary).commitAllowingStateLoss();
                        break;
                    case R.id.item2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new MemoViewFragment()).commit();

                        //transaction.replace(R.id.home_ly, fragmentMemo).commitAllowingStateLoss();
                        break;
                    case R.id.item3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new CalendarViewFragment()).commit();
                        //transaction.replace(R.id.home_ly, fragmentCalendar).commitAllowingStateLoss();
                        break;
                }
                return false;
            }
        });
    }
}