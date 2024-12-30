/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class UserServiceImpl implements UserService {
    private Map<String, String> userDatabase = new HashMap<>();

    public UserServiceImpl() {
        userDatabase.put("John Smith", "johnsmith123@");
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        return password.equals(userDatabase.get(username));
    }
}

