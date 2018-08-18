package com.example.licho.sesion5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button buttonWeb;
    Button buttonFrame;
    EditText nombre;
    Spinner nivel;
    Button buttonLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFrame = (Button) findViewById(R.id.buttonFrame);
        nombre = (EditText) findViewById(R.id.nombre);
        nivel = (Spinner) findViewById(R.id.nivel);

        buttonFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FrameActivity.class);
                intent.putExtra("mensaje", nombre.getText().toString() + " "+nivel.getSelectedItem().toString());
                startActivity(intent);
            }
        });

        buttonWeb = (Button) findViewById(R.id.buttonWeb);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WebActivity.class);
                startActivity(intent);
            }
        });

        buttonLista = (Button) findViewById(R.id.buttonLista);

    }
}
