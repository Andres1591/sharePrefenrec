package com.example.andres.proyectomvp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextInputEditText txtUsername, txtPassword;
    UserSessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        session = new UserSessionManager(getApplicationContext());

        txtUsername = (TextInputEditText) findViewById(R.id.username);
        txtPassword = (TextInputEditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String username = txtUsername.getText().toString();
                String  password = txtPassword.getText().toString();


                if(username.trim().length() > 0 && password.trim().length() > 0){

                    if(username.equals("andres") && password.equals("1234")){

                        session.createUserLoginSession("Andres armas",
                                "lardinarmas@gmail.com");

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "clave o usuario incorrecto",
                                Toast.LENGTH_LONG).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Ingrese sus usuario y clave por favor",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
