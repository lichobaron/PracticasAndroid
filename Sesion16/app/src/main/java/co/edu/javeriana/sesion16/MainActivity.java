package co.edu.javeriana.sesion16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonService;
    Button buttonQ1;
    Button buttonQ2;
    Button buttonQ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonService = findViewById(R.id.buttonService);
        buttonService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(v.getContext(), HelloIntentService.class));
            }
        });

        final Intent intent = new Intent(MainActivity.this, RESTActivity.class);
        final Bundle bundle = new Bundle();

        buttonQ1 = findViewById(R.id.buttonQ1);
        buttonQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type","type1");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        buttonQ2 = findViewById(R.id.buttonQ2);
        buttonQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type","type2");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        buttonQ3 = findViewById(R.id.buttonQ3);
        buttonQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("type","type3");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }
}
