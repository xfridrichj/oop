package oop.model.program;

import java.io.*;

public class User implements Serializable{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
