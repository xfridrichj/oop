package oop.controller;

import java.io.*;

public class User implements Serializable{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {return password;}

    public String getUsername() {
        return username;
    }
}
