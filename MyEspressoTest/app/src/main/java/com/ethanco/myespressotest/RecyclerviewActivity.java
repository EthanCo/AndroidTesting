package com.ethanco.myespressotest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by EthanCo on 2016/8/26.
 */
public class RecyclerviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final TextView textView = (TextView) findViewById(R.id.text);
        textView.setBackgroundColor(Color.LTGRAY);

        recyclerView.setHasFixedSize(true); //如果item的高度固定不变，设置这个属性能提高性能
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NumberedAdapter(30, new NumberedAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                textView.setText(String.valueOf(position));
                textView.setVisibility(View.VISIBLE);
            }
        }));

    }
}
