package com.hackthon.jsrathore.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText userName,password;
    private Button login;
    private TextView registerHere;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        registerHere=(TextView)findViewById(R.id.registerhere);
        userLocalStore=new UserLocalStore(this);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            User user =new User(null,null);

                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);


            }
        });

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(login.this,register.class));

            }
        });



    }





}
