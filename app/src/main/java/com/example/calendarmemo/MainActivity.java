package com.example.calendarmemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private AppCompatActivity binding;
    public CalendarView calendarView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainHome fragmentHome = new MainHome();
    private MemoViewFragment fragmentMemo = new MemoViewFragment();
    private DiaryViewFragment fragmentDiary = new DiaryViewFragment();
    private CalendarViewFragment fragmentCalendar = new CalendarViewFragment();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.CalendarView);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_view, fragmentCalendar).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.option_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Oitem1:
                                Intent diaryintent = new Intent(getApplicationContext(), com.example.calendarmemo.DiaryActivity.class);
                                startActivity(diaryintent);
                                break;
                            case R.id.Oitem2:
                                Intent memointent = new Intent(getApplicationContext(), com.example.calendarmemo.MemoActivity.class);
                                startActivity(memointent);
                                break;
                            case R.id.Oitem3:
                                Intent calendarintent = new Intent(getApplicationContext(), com.example.calendarmemo.CalendarActivity.class);
                                startActivity(calendarintent);
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

    }//onCreate

class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (menuItem.getItemId()){
            case R.id.homeB:
                transaction.replace(R.id.nav_view,fragmentHome).commitAllowingStateLoss();
                break;
            case R.id.item1:
                transaction.replace(R.id.nav_view,fragmentDiary).commitAllowingStateLoss();
                break;
            case R.id.item2:
                transaction.replace(R.id.nav_view,fragmentMemo).commitAllowingStateLoss();
                break;
            case R.id.item3:
                transaction.replace(R.id.nav_view,fragmentCalendar).commitAllowingStateLoss();
                break;

        }
        return true;
    }
}
}