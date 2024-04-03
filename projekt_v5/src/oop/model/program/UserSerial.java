package oop.model.program;
import oop.model.program.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserSerial {
    public static void serializeUsers(Map<String, User> users, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<String, User> deserializeUsers(String filename) {
        Map<String, User> users = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            users = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    public static void main(String [] args){
        Map<String,User> allUsers = new HashMap<>();
        allUsers.put("user1", new User("user1", "password123"));
        allUsers.put("user2", new User("user2", "password456"));
        System.out.println("Hotovo");
    }
}
