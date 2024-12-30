/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author Admin
 */
public class Product {
 private int id;
private String name;
private double price;


public Product(int id, String name, double price)
{
    this.id=id;
    this.name=name;
    this.price=price;
}
public String getName() 
{ 
    return name;
}
public double getPrice() 
{ 
    return price; 
}

}
