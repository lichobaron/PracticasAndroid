package com.example.licho.sesion6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonContactos;
    Button buttonMainCamara;
    Button buttonLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContactos = (Button) findViewById(R.id.buttonContactos);
        buttonContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ContactosActivity.class);
                startActivity(intent);
            }
        });

        buttonMainCamara = (Button) findViewById(R.id.buttonMainCamara);
        buttonMainCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), CamaraActivity.class));
            }
        });

        buttonLocation = (Button) findViewById(R.id.buttonLocation);
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), LocationActivity.class));
            }
        });

    }
}
