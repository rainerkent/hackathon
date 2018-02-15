package com.r2sdittos.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by marl on 2/15/18.
 */

public class LoginActivity extends AppCompatActivity {
    //widgets
    private EditText email;
    private EditText pass;
    private Button btnRegister;
    private Button btnLogin;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        refID();
        init();
        setupFirebase();

    }

    private void setupFirebase() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void refID() {
        email = findViewById(R.id.etRegEmail);
        pass = findViewById(R.id.etRegPassword);
        btnRegister = findViewById(R.id.registerbtn);
        btnLogin = findViewById(R.id.btnlogin);
    }

    private void init() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPass = pass.getText().toString();
                if(!isEmpty(userEmail, userPass)) {

//                    mAuth.signInWithEmailAndPassword(userEmail, userPass)
//                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if(task.isSuccessful()) {
                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                        startActivity(intent);
//                                    }
//                                    else {
//                                        Toast.makeText(LoginActivity.this, "Authentication fail", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
                }
                else {
                    Toast.makeText(LoginActivity.this, "Input all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEmpty(String text, String textTwo) {
        return TextUtils.isEmpty(text) || TextUtils.isEmpty(textTwo);
    }
}
