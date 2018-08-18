package com.example.licho.sesion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    WebView google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        google = (WebView) findViewById(R.id.google);
        google.loadUrl("https://www.google.com.co/");
    }
}
