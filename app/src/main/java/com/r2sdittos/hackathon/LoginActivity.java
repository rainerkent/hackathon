package com.r2sdittos.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by marl on 2/15/18.
 */

public class LoginActivity extends AppCompatActivity {
    //widgets
    private EditText email;
    private EditText pass;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        refID();
        init();

    }

    private void refID() {
        email = findViewById(R.id.etRegEmail);
        pass = findViewById(R.id.etRegPassword);
        btnRegister = findViewById(R.id.registerbtn);
    }

    private void init() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
