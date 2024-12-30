/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layeredarchitecture;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class LibraryUI {
//    private LibraryManager libraryManager;
//
//    public LibraryUI(LibraryManager libraryManager) {
//        this.libraryManager = libraryManager;
//    }
//
//    public void start() {
//        JFrame frame = new JFrame("Library Management");
//        frame.setSize(600, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//        placeComponents(panel);
//
//        frame.setVisible(true);
//    }
//
//    private void placeComponents(JPanel panel) {
//        panel.setLayout(null);
//
//        
//        JLabel titleLabel = new JLabel("Book Title:");
//        titleLabel.setBounds(10, 20, 80, 25);
//        panel.add(titleLabel);
//
//        JTextField titleField = new JTextField(20);
//        titleField.setBounds(100, 20, 165, 25);
//        panel.add(titleField);
//
//        JLabel authorLabel = new JLabel("Author:");
//        authorLabel.setBounds(10, 50, 80, 25);
//        panel.add(authorLabel);
//
//        JTextField authorField = new JTextField(20);
//        authorField.setBounds(100, 50, 165, 25);
//        panel.add(authorField);
//
//        JLabel genreLabel = new JLabel("Genre:");
//        genreLabel.setBounds(10, 80, 80, 25);
//        panel.add(genreLabel);
//
//        JTextField genreField = new JTextField(20);
//        genreField.setBounds(100, 80, 165, 25);
//        panel.add(genreField);
//
//        JLabel quantityLabel = new JLabel("Quantity:");
//        quantityLabel.setBounds(10, 110, 80, 25);
//        panel.add(quantityLabel);
//
//        JTextField quantityField = new JTextField(20);
//        quantityField.setBounds(100, 110, 165, 25);
//        panel.add(quantityField);
//
//        // Add Book button
//        JButton addButton = new JButton("Add Book");
//        addButton.setBounds(10, 140, 120, 25);
//        panel.add(addButton);
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String title = titleField.getText();
//                String author = authorField.getText();
//                String genre = genreField.getText();
//                int quantity = Integer.parseInt(quantityField.getText());
//                libraryManager.addBook(title, author, genre, quantity);
//                JOptionPane.showMessageDialog(null, "Book Added!");
//            }
//        });
//
//        // Remove Book button
//        JButton removeButton = new JButton("Remove Book");
//        removeButton.setBounds(10, 180, 150, 25);
//        panel.add(removeButton);
//        removeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String title = titleField.getText();
//                libraryManager.removeBook(title);
//                JOptionPane.showMessageDialog(null, "Book Removed!");
//            }
//        });
//
//        // Display Books button
//        JButton displayButton = new JButton("Display Books");
//        displayButton.setBounds(10, 220, 150, 25);
//        panel.add(displayButton);
//        displayButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StringBuilder bookList = new StringBuilder();
//                for (Book book : libraryManager.displayBooks()) {
//                    bookList.append(book.title).append(" by ").append(book.author)
//                            .append(", Genre: ").append(book.genre)
//                            .append(", Quantity: ").append(book.quantity).append("\n");
//                }
//                JOptionPane.showMessageDialog(null, bookList.toString());
//            }
//        });
//
//        // Borrow Book button
//        JButton borrowButton = new JButton("Borrow Book");
//        borrowButton.setBounds(10, 260, 150, 25);
//        panel.add(borrowButton);
//        borrowButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String title = titleField.getText();
//                String borrower = JOptionPane.showInputDialog("Enter Borrower's Name:");
//                if (libraryManager.borrowBook(borrower, title)) {
//                    JOptionPane.showMessageDialog(null, "Book Borrowed!");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Borrow Failed! Book might be unavailable.");
//                }
//            }
//        });
//
//        // Return Book button
//        JButton returnButton = new JButton("Return Book");
//        returnButton.setBounds(10, 300, 150, 25);
//        panel.add(returnButton);
//        returnButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String title = titleField.getText();
//                String borrower = JOptionPane.showInputDialog("Enter Borrower's Name:");
//                if (libraryManager.returnBook(borrower, title)) {
//                    JOptionPane.showMessageDialog(null, "Book Returned!");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Return Failed!");
//                }
//            }
//        });
//
//        // Display Records button
//        JButton recordButton = new JButton("Display Records");
//        recordButton.setBounds(10, 340, 150, 25);
//        panel.add(recordButton);
//        recordButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StringBuilder records = new StringBuilder();
//                for (Record record : libraryManager.displayRecords()) {
//                    records.append(record).append("\n");
//                }
//                JOptionPane.showMessageDialog(null, records.toString());
//            }
//        });
//    }
//    
    
    
    private LibraryManager libraryManager;

    public LibraryUI(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public void start() {
        JFrame frame = new JFrame("Library Management");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

      
        JLabel titleLabel = new JLabel("Book Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleField = new JTextField(20);
        titleField.setBounds(100, 20, 165, 25);
        panel.add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 50, 80, 25);
        panel.add(authorLabel);

        JTextField authorField = new JTextField(20);
        authorField.setBounds(100, 50, 165, 25);
        panel.add(authorField);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(10, 80, 80, 25);
        panel.add(genreLabel);

        JTextField genreField = new JTextField(20);
        genreField.setBounds(100, 80, 165, 25);
        panel.add(genreField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(10, 110, 80, 25);
        panel.add(quantityLabel);

        JTextField quantityField = new JTextField(20);
        quantityField.setBounds(100, 110, 165, 25);
        panel.add(quantityField);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(10, 150, 120, 25);
        panel.add(addButton);

        JButton removeButton = new JButton("Remove Book");
        removeButton.setBounds(150, 150, 120, 25);
        panel.add(removeButton);

        JButton borrowButton = new JButton("Borrow Book");
        borrowButton.setBounds(10, 190, 120, 25);
        panel.add(borrowButton);

        JButton returnButton = new JButton("Return Book");
        returnButton.setBounds(150, 190, 120, 25);
        panel.add(returnButton);

        JButton displayButton = new JButton("Display Books");
        displayButton.setBounds(10, 230, 150, 25);
        panel.add(displayButton);

        JButton recordButton = new JButton("View Records");
        recordButton.setBounds(10, 270, 150, 25);
        panel.add(recordButton);

      
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                String genre = genreField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                libraryManager.addBook(title, author, genre, quantity);
                JOptionPane.showMessageDialog(null, "Book Added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Quantity");
            }
        });
        
        
        
    

        removeButton.addActionListener(e -> {
            String title = titleField.getText();
            libraryManager.removeBook(title);
            JOptionPane.showMessageDialog(null, "Book Removed!");
        });

        borrowButton.addActionListener(e -> {
            String title = titleField.getText();
            String borrower = JOptionPane.showInputDialog("Enter Borrower's Name:");
            if (libraryManager.borrowBook(title, borrower)) {
                JOptionPane.showMessageDialog(null, "Book Borrowed!");
            } else {
                JOptionPane.showMessageDialog(null, "Book Not Available!");
            }
        });

        returnButton.addActionListener(e -> {
            String title = titleField.getText();
            String borrower = JOptionPane.showInputDialog("Enter Borrower's Name:");
            if (libraryManager.returnBook(title, borrower)) {
                JOptionPane.showMessageDialog(null, "Book Returned!");
            } else {
                JOptionPane.showMessageDialog(null, "Return Failed!");
            }
        });

        displayButton.addActionListener(e -> {
            StringBuilder bookList = new StringBuilder();
            for (Book book : libraryManager.displayBooks()) {
                bookList.append(book.getTitle()).append(" by ").append(book.author)
                        .append(", Genre: ").append(book.genre)
                        .append(", Quantity: ").append(book.getQuantity()).append("\n");
            }
            JOptionPane.showMessageDialog(null, bookList.toString());
        });

        recordButton.addActionListener(e -> {
            StringBuilder recordList = new StringBuilder();
            for (Record record : libraryManager.displayRecords()) {
                recordList.append(record.getBorrowerName()).append(" borrowed ")
                        .append(record.getBookTitle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, recordList.toString());
        });
        
        
    
    }
}
