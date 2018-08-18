package com.example.licho.taller1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class ResultFibActivity extends AppCompatActivity {

    LinearLayout results;
    Vector<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_fib);

        int n = Integer.parseInt(getIntent().getStringExtra("mensaje"));
        results = (LinearLayout) findViewById(R.id.results);

        numbers = new Vector<Integer>();
        numbers.add(0);
        numbers.add(1);

        if(n<3){
            if(n==2){
                TextView textView = new TextView(this);
                textView.setText(Integer.toString(0));
                textView.setTextSize(30);
                results.addView(textView);
                textView = new TextView(this);
                textView.setText(Integer.toString(1));
                textView.setTextSize(30);
                results.addView(textView);
            }
            else{
                TextView textView = new TextView(this);
                textView.setText(Integer.toString(0));
                textView.setTextSize(30);
                results.addView(textView);
            }
        }
        else{
            TextView textView1 = new TextView(this);
            textView1.setText(Integer.toString(0));
            textView1.setTextSize(30);
            results.addView(textView1);
            textView1 = new TextView(this);
            textView1.setText(Integer.toString(1));
            textView1.setTextSize(30);
            results.addView(textView1);
            for(int i= 2; i<n; i++){
                int r = numbers.get(numbers.size()-1)+numbers.get(numbers.size()-2);
                numbers.add(r);
                TextView textView = new TextView(this);
                textView.setTextSize(30);
                textView.setText(Integer.toString(r));
                results.addView(textView);
            }
        }
    }

}
