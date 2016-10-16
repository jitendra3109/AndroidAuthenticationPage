package com.hackthon.jsrathore.login;

/**
 * Created by jsrathore on 10/16/16.
 */
public class User {

      String name,username,password;
      int age;
      public User(String name,int age,String username,String password){
          this.name=name;
          this.age=age;
          this.username=username;
          this.password=password;
      }
      public User(String username,String password){
          this.age=-1;
          this.password=password;
          this.name=username;
          this.name="";
      }

}
