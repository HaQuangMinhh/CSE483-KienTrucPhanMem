/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */


public class LibraryUI extends JFrame {
       private LibraryService libraryService;
    private JTextField titleField, authorField, genreField, quantityField;
    private JTextField borrowerNameField, borrowBookTitleField;
    private JTextArea displayArea;

    public LibraryUI() {
        libraryService = new LibraryService();
        setupUI();
    }

    private void setupUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
      
        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        titleField = new JTextField(30);
        authorField = new JTextField(30);
        genreField = new JTextField(30);
        quantityField = new JTextField(30);
        borrowerNameField = new JTextField(30);
        borrowBookTitleField = new JTextField(30);

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Borrower Name:"));
        inputPanel.add(borrowerNameField);
        inputPanel.add(new JLabel("Book to Borrow:"));
        inputPanel.add(borrowBookTitleField);

      
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Book");
        JButton deleteButton = new JButton("Delete Book");
        JButton borrowButton = new JButton("Borrow Book");
        JButton returnButton = new JButton("Return Book");
        JButton displayBooksButton = new JButton("Display Books");
        JButton displayRecordsButton = new JButton("Display Records");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(displayBooksButton);
        buttonPanel.add(displayRecordsButton);

       // size of display for customer input
        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

      
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

       
        addButton.addActionListener(e -> addBook());
        deleteButton.addActionListener(e -> deleteBook());
        borrowButton.addActionListener(e -> borrowBook());
        returnButton.addActionListener(e -> returnBook());
        displayBooksButton.addActionListener(e -> displayBooks());
        displayRecordsButton.addActionListener(e -> displayRecords());

        pack();
        setLocationRelativeTo(null);
    }

    private void addBook() {
        try {
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = genreField.getText();
            int quantity = Integer.parseInt(quantityField.getText());

            libraryService.registerBook(title, author, genre, quantity);
            displayArea.setText("Book added successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            displayArea.setText("Please enter valid quantity!");
        }
    }

    private void deleteBook() {
        String title = titleField.getText();
        boolean deleted = libraryService.deleteBook(title);
        displayArea.setText(deleted ? "Book deleted successfully!" : "Book not found!");
        clearFields();
    }

    private void borrowBook() {
        String borrowerName = borrowerNameField.getText();
        String bookTitle = borrowBookTitleField.getText();
        boolean borrowed = libraryService.borrowBook(borrowerName, bookTitle);
        displayArea.setText(borrowed ? "Book borrowed successfully!" : "Book not available!");
        clearFields();
    }

    private void returnBook() {
        String borrowerName = borrowerNameField.getText();
        String bookTitle = borrowBookTitleField.getText();
        boolean returned = libraryService.returnBook(borrowerName, bookTitle);
        displayArea.setText(returned ? "Book returned successfully!" : "Return failed!");
        clearFields();
    }

    private void displayBooks() {
        StringBuilder sb = new StringBuilder("Books in Library:\n\n");
        for (Book book : libraryService.getAllBooks()) {
            sb.append(book.toString()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void displayRecords() {
        StringBuilder sb = new StringBuilder("Borrowing Records:\n\n");
        for (Record record : libraryService.getAllRecords()) {
            sb.append(record.toString()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        genreField.setText("");
        quantityField.setText("");
        borrowerNameField.setText("");
        borrowBookTitleField.setText("");
    }
    }

   
    

