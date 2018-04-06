package com.example.amr.movieapplication.activitie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amr.movieapplication.R;

public class LoginActivity extends AppCompatActivity {

    EditText email ,password ;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("pref_file" , MODE_PRIVATE);
        editor = sharedPreferences.edit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("emailKey" , email.getText().toString());
                editor.putString("passwordKey" , password.getText().toString());
                editor.commit();
                editor.apply();

                Intent intent = new Intent(LoginActivity.this , MovieActivity.class);
                startActivity(intent);
            }
        });
    }
}
