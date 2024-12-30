/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layeredarchitecture;


import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class LibraryManager {
    private Database database;

    public LibraryManager(Database database) {
        this.database = database;
    }

    public void addBook(String title, String author, String genre, int quantity) {
        for (Book book : database.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setQuantity(book.getQuantity() + quantity);
                return;
            }
        }
        database.books.add(new Book(title, author, genre, quantity));
    }
    
    
    
    

    public boolean borrowBook(String borrowerName, String bookTitle) {
        Book bookToBorrow = null;
        for (Book book : database.books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && book.getQuantity() > 0) {
                bookToBorrow = book;
                break;
            }
        }
        if (bookToBorrow == null) {
            return false; 
        }

        for (Borrower borrower : database.borrowers) {
            if (borrower.getName().equalsIgnoreCase(borrowerName)) {
                borrower.getBorrowedBooks().add(bookToBorrow);
                bookToBorrow.setQuantity(bookToBorrow.getQuantity() - 1);
                database.records.add(new Record(borrowerName, bookTitle));
                return true;
            }
        }

        return false; 
    }

    public boolean returnBook(String borrowerName, String bookTitle) {
        for (Borrower borrower : database.borrowers) {
            if (borrower.getName().equalsIgnoreCase(borrowerName)) {
                Iterator<Book> iterator = borrower.getBorrowedBooks().iterator();
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                        iterator.remove();
                        book.setQuantity(book.getQuantity() + 1);
                        return true;
                    }
                }
            }
        }
        return false; 
    }

    public ArrayList<Book> displayBooks() {
        return database.books;
    }

    public ArrayList<Record> displayRecords() {
        return database.records;
    }

    void removeBook(String title) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
