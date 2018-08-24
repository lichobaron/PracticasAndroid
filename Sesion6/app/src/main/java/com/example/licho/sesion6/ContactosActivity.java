package com.example.licho.sesion6;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactosActivity extends AppCompatActivity {

    final static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    TextView textPermiso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        textPermiso = (TextView) findViewById(R.id.textPermiso);
        requestPermission(this, Manifest.permission.READ_CONTACTS,"nothing",MY_PERMISSIONS_REQUEST_READ_CONTACTS);

    }

    @Override
    public void onResume(){
        super.onResume();
        requestPermission(this, Manifest.permission.READ_CONTACTS,"nothing",MY_PERMISSIONS_REQUEST_READ_CONTACTS);

    }

    private void initViews(Activity context, String permiso){
        if (ContextCompat.checkSelfPermission(context, permiso) != PackageManager.PERMISSION_GRANTED) {

        }
        else{

        }
    }



    private void requestPermission(Activity context, String permiso, String justificacion, int idCode) {
        // El contexto es la actividad principal
        if (ContextCompat.checkSelfPermission(context, permiso) != PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(context, /*Manifest.permission.READ_CONTACTS*/permiso) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if(ActivityCompat.shouldShowRequestPermissionRationale(context, permiso)) {
                    // Show an expanation to the user *asynchronously*
                }
                // request the permission.
                ActivityCompat.requestPermissions(context, new String[]{permiso}, idCode);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS es una
                // constante definida en la aplicación, se debe usar
                // en el callback para identificar el permiso
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                textPermiso = (TextView) findViewById(R.id.textPermiso);
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, continue with task related to permissio

                    textPermiso.setText("Permiso aprobado");


                } else {
                    // permission denied, disable functionality that depends on this permission.
                    textPermiso.setText("Permiso denegado");
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    /*public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {

    }*/

}
