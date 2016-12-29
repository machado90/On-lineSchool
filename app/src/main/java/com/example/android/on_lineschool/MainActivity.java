package com.example.android.on_lineschool;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText leditTextEmail;
    private EditText leditTextPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leditTextEmail = (EditText) findViewById(R.id.leditTextEmail);
        leditTextPassword = (EditText) findViewById(R.id.leditTextPassword);
        firebaseAuth = firebaseAuth.getInstance();
    }

    public void bLogin_click (View v) {

        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Por favor aguarde...", "A processar...", true);

        (firebaseAuth.signInWithEmailAndPassword(leditTextEmail.getText().toString(),leditTextPassword.getText().toString())).addOnCompleteListener((new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Login realizado com sucesso!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    i.putExtra ("Email", firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);
                } else {

                    Toast.makeText(MainActivity.this, "Um dos dados encontra se incorrecto por favor tente novamente.", Toast.LENGTH_LONG).show();

                }
            }
        }
        )
        );

    }
}
