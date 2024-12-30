/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

/**
 *
 * @author Admin
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private int quantity;

    public Book(String title, String author, String genre, int quantity) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
    }

  
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return " Book Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Quantity: " + quantity;
    }
} 

