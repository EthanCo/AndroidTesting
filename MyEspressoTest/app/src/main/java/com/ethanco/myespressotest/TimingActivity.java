package com.ethanco.myespressotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by EthanCo on 2016/8/26.
 */
public class TimingActivity extends AppCompatActivity {
    private Button toggleButton;
    private TextView elapsedTimeView;
    private TextView resultView;

    private long startTime = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);
        toggleButton = (Button) findViewById(R.id.toggle_button);
        elapsedTimeView = (TextView) findViewById(R.id.elapsed_Time);
        resultView = (TextView) findViewById(R.id.result);
    }

    public void toggle(View v) {
        if (startTime == -1) {
            toggleButton.setText(R.string.stop);
            elapsedTimeView.setText(null);
            resultView.setText(null);
            startTime = System.currentTimeMillis();
        } else {
            long elapsed = System.currentTimeMillis() - startTime;
            elapsedTimeView.setText(getString(R.string.elapsed_time, elapsed / 1000f));
            toggleButton.setText(R.string.start);
            resultView.setText(elapsed >= DateUtils.MINUTE_IN_MILLIS ?
                    R.string.success : R.string.failure);
            startTime = -1;
        }
    }
}
