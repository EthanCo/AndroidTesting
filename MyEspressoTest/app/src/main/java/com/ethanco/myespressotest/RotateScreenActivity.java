package com.ethanco.myespressotest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * @Description 旋转屏幕 调用onSaveInstanceState
 * Created by EthanCo on 2016/8/26.
 */
public class RotateScreenActivity extends AppCompatActivity {

    private static final java.lang.String KEY_COUNT = "key_count";
    private TextView countView;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        countView = (TextView) findViewById(R.id.count);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0);
        }

        updateCount();
    }

    private void updateCount() {
        countView.setText(String.valueOf(count));
    }

    public void increment(View v) {
        count += 1;
        updateCount();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }
}
