package com.example.sala_c.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout lay = (LinearLayout) findViewById(R.id.lay);
        TextView textView = new TextView(this);
        textView.setText(getIntent().getStringExtra("mensaje"));
        lay.addView(textView);
    }

}
