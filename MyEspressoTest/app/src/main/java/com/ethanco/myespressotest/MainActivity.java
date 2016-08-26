package com.ethanco.myespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView greetingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

        greetingView = (TextView) findViewById(R.id.greeting);
    }

    public void greet(View v) {
        greetingView.setText(R.string.hello);
    }
}
