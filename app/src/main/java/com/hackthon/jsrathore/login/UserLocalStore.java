package com.hackthon.jsrathore.login;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jsrathore on 10/16/16.
 */
public class UserLocalStore {
    public static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase=context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putInt("age",user.age);
        spEditor.putString("name",user.name);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String name=userLocalDatabase.getString("name","");
        int age=userLocalDatabase.getInt("age",-1);
        String username=userLocalDatabase.getString("username","");
        String password=userLocalDatabase.getString("password","");

        User storeUser=new User(name,age,username,password);

      return storeUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
    }

     public boolean getUserLoggedIn(){
         if (userLocalDatabase.getBoolean("loggedIn",false)==true){
             return true;
         }else{
             return false;
         }
     }


    public void clearUserData(){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}

