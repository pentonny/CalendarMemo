package com.example.calendarmemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        //리사이클러뷰에 표시할 데이터 리스트 생성.
        super.onCreate(saveInstanceState);
        setContentView(R.layout.memoview);
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<100; i++) {
            list.add(String.format("TEXT %d", i)) ;
        }
        //리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //리사이쿨러뷰에 RecyclerAdapter 객체 지정.
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}
