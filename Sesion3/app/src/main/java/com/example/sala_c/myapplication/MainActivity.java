package com.example.sala_c.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity {

    EditText name;
    Button ok;
    EditText porcentaje;
    EditText numero;
    Button calcular;
    TextView resultado;
    EditText mensaje;
    Button actividad;
    Button mylog;
    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        ok = (Button) findViewById(R.id.OK);
        porcentaje = (EditText) findViewById(R.id.porcentaje);
        numero = (EditText) findViewById(R.id.numero);
        calcular = (Button) findViewById(R.id.calcular);
        resultado = (TextView) findViewById(R.id.resultado);
        actividad = (Button) findViewById(R.id.actividad);
        mensaje = (EditText) findViewById(R.id.mensaje);
        mylog = (Button) findViewById(R.id.mylog);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Hola "+ name.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = Integer.parseInt(porcentaje.getText().toString());
                int n = Integer.parseInt(numero.getText().toString());
                int r = (n*p)/100;
                resultado.setText(Integer.toString(r));
            }
        });

        actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("mensaje", mensaje.getText().toString());
                startActivity(intent);
            }
        });

        mylog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                Log.i("MyApp",Integer.toString(clicks));
            }
        });
    }
}
