package com.example.yaadvir.project;

//This is a Singleton !!!

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public class Credential implements Serializable {
    private String username, password;

    private static Credential instance = null; //At first, this is null, after, its an Object

    private Credential() {
        this.username="admin";
        this.password="parmar";
    }




    public static Credential getInstance() {
        if (instance == null) {
            instance = new Credential();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
