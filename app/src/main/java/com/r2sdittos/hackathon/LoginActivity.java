package com.r2sdittos.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by marl on 2/15/18.
 */

public class LoginActivity extends AppCompatActivity {
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        refID();


    }

    public void refID() {
        email = findViewById(R.id.etRegEmail);
        pass = findViewById(R.id.etRegPassword);
    }
}
