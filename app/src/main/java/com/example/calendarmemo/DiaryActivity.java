package com.example.calendarmemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DiaryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savebtn, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);

        switch (item.getItemId()) {
            case R.id.save_btn:
                toast.setText("저장");
                break;
        }

        toast.show();

        return super.onOptionsItemSelected(item);
    }
}
