package com.example.calendarmemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.CalendarView;
import android.widget.PopupMenu;
import android.widget.PopupMenu;


public class MainHome extends Fragment {
    private View view;
    public CalendarView calendarView;
    private Object MenuItem;

    // TODO: Rename and change types of parameters
    public MainHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void onResum(){
        super.onResume();
        getActivity().invalidateOptionsMenu();
    }
    public void onCreteOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.option_menu,menu);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        calendarView = calendarView.findViewById(R.id.CalendarView);
        view = inflater.inflate(R.layout.fragment_main_home,container,false);
        MenuItem = (MenuItem) view.findViewById(R.id.CalendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                PopupMenu popup = new PopupMenu(getContext(), view);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.Oitem1:
                                Intent diaryintent = new Intent(getContext(), DiaryActivity.class);
                                startActivity(diaryintent);
                                break;
                            case R.id.Oitem2:
                                Intent memointent = new Intent(getContext(), MemoActivity.class);
                                startActivity(memointent);
                                break;
                            case R.id.Oitem3:
                                Intent calendarintent = new Intent(getContext(), CalendarActivity.class);
                                startActivity(calendarintent);
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
        return view;
    }
}