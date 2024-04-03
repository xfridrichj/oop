/*package oop.controller;
import oop.view.Main.*;

import java.io.*;

public class LoginRead{
    public boolean authenticateUser(String currentPassword, String storedPassword){
        return storedPassword != null && storedPassword.equals(currentPassword);
    }
    public static void main(String [] args){
        InputStream inputStream = LoginRead.class.getResourceAsStream("data.txt");

        // If inputStream is null, it means the file is not found
        if (inputStream == null) {
            System.err.println("File not found!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            // Read and print each line of the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}*/
package oop.controller;

import java.io.*;

public class LoginRead {
    public boolean authenticateUser(String storedPassword, String currentPassword) {
        return storedPassword != null && storedPassword.equals(currentPassword);
    }

    public static void main(String[] args) {
        String currentPassword = ""; // You need to set the value of currentPassword here

        InputStream inputStream = LoginRead.class.getResourceAsStream("data.txt");

        // If inputStream is null, it means the file is not found
        /*if (inputStream == null) {
            System.err.println("File not found!");
            return;
        }*/

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            // Read and print each line of the file
            while ((line = reader.readLine()) != null) {
                currentPassword = line;
                System.out.println(currentPassword);
                //boolean authenticateUser(stored)
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    /*LoginRead loginRead = new LoginRead();
            boolean isAuthenticated = loginRead.authenticateUser(storedPassword, currentPassword);*/
}
