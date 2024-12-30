/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layeredarchitecture;



/**
 *
 * @author Admin
 */
public class Book {
   String title;
    String author;
    String genre;
    int quantity;

    public Book(String title, String author, String genre, int quantity) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
}

