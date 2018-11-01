package co.edu.javeriana.authmaps;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText textNombre;
    EditText textApellido;
    EditText textCorreo;
    EditText textPassword;
    Button buttonRegister;

    private final String TAG = "Firebase App";
    public static final String PATH_USERS="users/";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();

        textNombre = findViewById(R.id.textNombre);
        textApellido = findViewById(R.id.textApellido);
        textCorreo = findViewById(R.id.textCorreo);
        textPassword = findViewById(R.id.textPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    register(textCorreo.getText().toString(), textPassword.getText().toString());
                }
            }
        });

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    //startActivity(new Intent(SignUpActivity.this, MapsActivity.class));
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

    }

    private void register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user!=null){ //Update user Info
                                UserProfileChangeRequest.Builder upcrb = new UserProfileChangeRequest.Builder();
                                upcrb.setDisplayName(textNombre.getText().toString()+" "+textApellido.getText().toString());
                                upcrb.setPhotoUri(Uri.parse("path/to/pic"));//fake uri, real one coming soon
                                user.updateProfile(upcrb.build());
                                //startActivity(new Intent(SignUpActivity.this, MapsActivity.class)); //o en el listener
                            }
                        }
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Fallo autenticación"+ task.getException().toString(),
                                    Toast.LENGTH_SHORT).show();
                            Log.e(TAG, task.getException().getMessage());
                        }
                        else{
                            FirebaseUser user = mAuth.getCurrentUser();
                            MyUser myUser = new MyUser();
                            myUser.setNombre(textNombre.getText().toString());
                            myUser.setApellido(textApellido.getText().toString());
                            myRef=database.getReference(PATH_USERS+user.getUid());
                            myRef.setValue(myUser);
                            startActivity(new Intent(SignUpActivity.this, MapsActivity.class)); //o en el listener
                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;
        String email = textCorreo.getText().toString();
        valid = isEmailValid(email);
        if (TextUtils.isEmpty(email)) {
            textCorreo.setError("Required.");
            valid = false;
        } else {
            textCorreo.setError(null);
        }
        String password = textPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            textPassword.setError("Required.");
            valid = false;
        } else {
            textPassword.setError(null);
        }
        String nombre = textNombre.getText().toString();
        if (TextUtils.isEmpty(nombre)) {
            textNombre.setError("Required.");
            valid = false;
        } else {
            textNombre.setError(null);
        }
        String apellido = textApellido.getText().toString();
        if (TextUtils.isEmpty(apellido)) {
            textApellido.setError("Required.");
            valid = false;
        } else {
            textApellido.setError(null);
        }
        return valid;
    }

    private boolean isEmailValid(String email) {
        boolean isValid = true;
        if (!email.contains("@") || !email.contains(".") || email.length() < 5){
            isValid = false;
            textCorreo.setError("Invalid email.");
        }
        return isValid;
    }

}
