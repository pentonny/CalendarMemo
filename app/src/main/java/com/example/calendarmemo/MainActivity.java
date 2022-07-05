package com.example.calendarmemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.calendarmemo.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private AppCompatActivity binding;
    public CalendarView calendarView;
    LinearLayout hom_ly;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.CalendarView);

        init(); //객체 정의
        SettingListener(); //리스너 등록
        bottomNavigationView.setSelectedItemId(R.id.homeB);

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
     private void init () {
    hom_ly = findViewById(R.id.home_ly);
    bottomNavigationView = findViewById(R.id.nav_view);
}
    private void SettingListener () {
        //선택 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener());
    }
class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.homeB: {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_ly, new HomeFragment())
                        .commit();
                return true;
            }
            case R.id.item1: {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_ly, new DiaryFragment())
                        .commit();
                return true;
            }
            case R.id.item2: {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_ly, new MemoFragment())
                        .commit();
                return true;
            }

        }

        return false;
    }
}
}