package com.example.licho.sesion6;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class ContactosActivity extends AppCompatActivity {

    final static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    ListView list;
    String[] mProjection;
    ContactsAdapter mContactsAdapter;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        list = (ListView) findViewById(R.id.list);
        mProjection = new String[]{
                ContactsContract.Profile._ID,
                ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
        };
        requestPermission(this, Manifest.permission.READ_CONTACTS, "Se necesita acceder a los contactos", MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        mContactsAdapter = new ContactsAdapter(this, null, 0);
        list.setAdapter(mContactsAdapter);
        loadListContacts();
    }

    private void loadListContacts(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED){
            mCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, mProjection, null,
                    null, null);
            mContactsAdapter.changeCursor(mCursor);

        }
        else {

        }
    }


    private void requestPermission(Activity context, String permission, String explanation, int requestId ){
        if (ContextCompat.checkSelfPermission(context,permission)!= PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?   
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,permission)) {
                Toast.makeText(context, explanation, Toast.LENGTH_LONG).show();
            }
            ActivityCompat.requestPermissions(context, new String[]{permission}, requestId);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS : {
                loadListContacts();
                break;
            }
        }
    }

}
