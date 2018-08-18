package com.example.licho.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    Button calcular;
    EditText n;
    Button calcular2;
    EditText n2;
    TextView footer;

    int numfib = 0;
    int numfac = 0;
    String lastfib = "";
    String lastfac = "";

    /*LinearLayout fib;
    Vector<Integer> numbers;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcular = (Button) findViewById(R.id.calcular);
        n = (EditText) findViewById(R.id.n);
        calcular2 = (Button) findViewById(R.id.calcular2);
        n2 = (EditText) findViewById(R.id.n2);

        /*numbers = new Vector<Integer>();
        numbers.add(0);
        numbers.add(1);
        TextView textView = new TextView(this);
        textView.setText("0,1");
        fib.addView(textView);*/

        calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                numfib++;
                lastfib = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                Intent intent = new Intent(view.getContext(), ResultFibActivity.class);
                intent.putExtra("mensaje", n.getText().toString());
                startActivity(intent);
                /*int r = numbers.get(numbers.size()-1)+numbers.get(numbers.size()-2);
                TextView textView = new TextView(view.getContext());
                textView.setText(Integer.toString(r));
                fib.addView(textView);
                //fib.append(Integer.toString(r)+"\n");
                numbers.add(r);*/
            }
        });

        calcular2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                numfac++;
                lastfac = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                Intent intent = new Intent(view.getContext(), FactorialActivity.class);
                intent.putExtra("mensaje", n2.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        //Toast.makeText(this, "Veces Fib. "+ numfib+"\nVeces Fac. "+numfac, Toast.LENGTH_SHORT).show();

        footer = (TextView) findViewById(R.id.footer);
        String content = "Veces Fib. "+ numfib+" Última vez: " +lastfib + "\nVeces Fac. "+numfac + " Última vez: " +lastfac;
        footer.setText(content);

    }
}
