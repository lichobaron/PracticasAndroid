package com.example.licho.sesion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FrameActivity extends AppCompatActivity {

    TextView textoDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        textoDatos = (TextView) findViewById(R.id.textoDatos);
        textoDatos.setText(getIntent().getStringExtra("mensaje"));
    }
}
