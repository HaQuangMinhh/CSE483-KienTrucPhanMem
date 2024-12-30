/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1test;

/**
 *
 * @author Admin
 */
public class Lab1test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("john");
        student.setAddress("232312321_fv");
        student.setPhone("029339494494949949");
        System.out.println("name:" + student.getName()+ " address:"+ student.getAddress()+ " phone:" + student.getPhone());
    }
}
