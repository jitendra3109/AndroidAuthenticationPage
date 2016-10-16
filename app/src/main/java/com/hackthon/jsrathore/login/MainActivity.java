package com.hackthon.jsrathore.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button logout;
    private EditText username,name,age,email,password;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout=(Button)findViewById(R.id.register);
         username=(EditText)findViewById(R.id.userid);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        userLocalStore=new UserLocalStore(this);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             userLocalStore.clearUserData();
             userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(MainActivity.this,login.class));

            }
        });
    }
    @Override
    protected  void onStart(){
        super.onStart();
        if (authenticate()==true){
            dispalyUserDetails();
         }else{
            startActivity(new Intent(MainActivity.this,login.class));
        }
    }
    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }
    private void dispalyUserDetails(){
        User user =userLocalStore.getLoggedInUser();

       username.setText(user.username);
        name.setText(user.name);
        age.setText(user.age);
        password.setText(user.password);

    }

}
