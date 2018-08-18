package com.example.licho.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    LinearLayout answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        answer = (LinearLayout) findViewById(R.id.answer);

        int n = Integer.parseInt(getIntent().getStringExtra("mensaje"));
        int x = 1;
        TextView textMult = new TextView(this);
        textMult.setTextSize(30);
        String r = "Multiplicación: ";

        for (int i=1; i <= n; i++){
            r += Integer.toString(i)+"*";
            x= x*i;
        }
        textMult.setText(r);
        answer.addView(textMult);
        TextView textView = new TextView(this);
        textView.setText("Resultado: "+ Integer.toString(x));
        textView.setTextSize(30);
        answer.addView(textView);
    }
}
