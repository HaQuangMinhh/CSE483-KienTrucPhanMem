/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LibraryService {
     private List<Book> books;
    private List<Borrower> borrowers;
    private List<Record> records;

    public LibraryService() {
        this.books = new ArrayList<>();
        this.borrowers = new ArrayList<>();
        this.records = new ArrayList<>();
    }
    
    
    
     public void registerBook(String title, String author, String genre, int quantity) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                book.setQuantity(book.getQuantity() + quantity);
                return;
            }
        }
        books.add(new Book(title, author, genre, quantity));
    }

 

    public boolean deleteBook(String title) {
        return books.removeIf(book -> book.getTitle().equals(title));
    }


    
    public void registerBorrower(String name, String address, String email, String phone) {
        Borrower newBorrower = new Borrower(name, address, email, phone);
        borrowers.add(newBorrower);
    }

    public Borrower findBorrower(String name) {
        return borrowers.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Borrower> getAllBorrowers() {
        return new ArrayList<>(borrowers);
    }

    public boolean borrowBook(String borrowerName, String bookTitle) {
        Borrower borrower = findBorrower(borrowerName);
        if (borrower == null) {
            return false;
        }

       
        Book bookToBorrow = books.stream()
                .filter(b -> b.getTitle().equals(bookTitle) && b.getQuantity() > 0)
                .findFirst()
                .orElse(null);

        if (bookToBorrow != null) {
            bookToBorrow.setQuantity(bookToBorrow.getQuantity() - 1);
            borrower.getBorrowedBooks().add(bookToBorrow);
            
            Record record = new Record(borrowerName, bookTitle, LocalDate.now().toString());
            records.add(record);
            return true;
        }
        return false;
    }

    public boolean returnBook(String borrowerName, String bookTitle) {
        Borrower borrower = findBorrower(borrowerName);
        if (borrower == null) {
            return false;
        }

       
        Book bookToReturn = borrower.getBorrowedBooks().stream()
                .filter(b -> b.getTitle().equals(bookTitle))
                .findFirst()
                .orElse(null);

        if (bookToReturn != null) {
            borrower.getBorrowedBooks().remove(bookToReturn);
            
           
            books.stream()
                .filter(b -> b.getTitle().equals(bookTitle))
                .findFirst()
                .ifPresent(b -> b.setQuantity(b.getQuantity() + 1));
            
            return true;
        }
        return false;
    }

    public List<Book> getBorrowedBooks(String borrowerName) {
        Borrower borrower = findBorrower(borrowerName);
        return borrower != null ? new ArrayList<>(borrower.getBorrowedBooks()) : new ArrayList<>();
        
        
        
    }
    
    
     public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Record> getAllRecords() {
        return new ArrayList<>(records);
    }
}
