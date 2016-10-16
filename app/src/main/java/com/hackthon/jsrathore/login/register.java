package com.hackthon.jsrathore.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity {
   private Button registerMe;
   private TextView login;
   private EditText username,name,age,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerMe=(Button)findViewById(R.id.register);
        login=(TextView)findViewById(R.id.gotologin);
        username=(EditText)findViewById(R.id.userid);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);




        login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(register.this,login.class));

         }

         });

        registerMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=name.getText().toString();
                String Username=username.getText().toString();
                String Password=password.getText().toString();
                int Age=Integer.parseInt(age.getText().toString());
                String Email=email.getText().toString();

                User registeredData=new User(Name,Age,Username,Password);

            }
        });

    }
}
