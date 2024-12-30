package com.training;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Database {
    // Declaring the database path, remember where you put your database
    private final static String DB_URL = "jdbc:sqlite:library.db";

    // Implement Method to add the book into the database
    static void addBook(String title, String author, String genre, String publicationDate, String isbn,
            boolean available) throws SQLException {
        String sql = "INSERT INTO books(title, author, genre ,publicationDate, isbn) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setString(4, publicationDate);
            pstmt.setString(5, isbn);
            pstmt.executeUpdate();

            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    // Implement Method to add the borrower into the database
    static void addBorrower(String name, String email, String phone, String address) throws SQLException {
        String sql = "INSERT INTO borrowers(name, email, phone, address) VALUES(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.executeUpdate();

            System.out.println("Borrower added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding borrower: " + e.getMessage());
        }
    }

    // Implement Method to add checkout into the database
    static void addCheckout(String bookID, String borrowerID, String coutdate, String duedate, String returnDate)
            throws SQLException {
        String sql = "INSERT INTO checkouts(book_id, borrower_id, count_date, due_date) VALUES(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, bookID);
            pstmt.setString(2, borrowerID);
            pstmt.setString(3, coutdate);
            pstmt.setString(4, duedate);
            pstmt.setString(5, returnDate);
            pstmt.executeUpdate();

            System.out.println("Checkout added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding checkout: " + e.getMessage());
        }
    }

    // Implement Method to create database with the three columns books,borrowers
    // and checkouts
    static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement()) {

            String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT NOT NULL," +
                    "author TEXT," +
                    "genre TEXT," +
                    "publicationDate TEXT," +
                    "isbn TEXT UNIQUE)";
            stmt.execute(createBooksTable);

            String createBorrowersTable = "CREATE TABLE IF NOT EXISTS borrowers (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT UNIQUE ," +
                    "phone TEXT, " +
                    "address TEXT)";
            stmt.execute(createBorrowersTable);

            String createCheckoutsTable = "CREATE TABLE IF NOT EXISTS checkouts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "book_id INTEGER NOT NULL," +
                    "borrower_id INTEGER NOT NULL," +
                    "count_date TEXT," +
                    "due_date TEXT," +
                    "FOREIGN KEY(book_id) REFERENCES books(id)," +
                    "FOREIGN KEY(borrower_id) REFERENCES borrowers(id))";
            stmt.execute(createCheckoutsTable);

            System.out.println("Database and tables created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    // Implement Method to delete the entry from the database given the id and the
    // table name
    static void delete(String tableName, String id) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();

            System.out.println("Record deleted successfully from " + tableName + " table.");
        } catch (SQLException e) {
            System.err.println("Error deleting record: " + e.getMessage());
        }
    }

    // Implement Method to refresh the tables with the updated data from the
    // database
    static void refreshTables(DefaultTableModel bookModel, DefaultTableModel borrowerModel,
            DefaultTableModel checkoutModel) {

        // You may look at the hint below for "Books tab", or just do it yourself

        bookModel.setRowCount(0);
        borrowerModel.setRowCount(0);
        checkoutModel.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // take database from book
            String selectBooksQuery = "SELECT id, title, author, genre, publicationDate, isbn FROM books";
            try (PreparedStatement stmt = conn.prepareStatement(selectBooksQuery);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("genre"),
                            rs.getString("publicationDate"),
                            rs.getString("isbn")
                    };
                    bookModel.addRow(rowData);
                }
            }

            // take date from borrowers
            String selectBorrowersQuery = "SELECT id, name, email, phone, address FROM borrowers";
            try (PreparedStatement stmt = conn.prepareStatement(selectBorrowersQuery);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("address")
                    };
                    borrowerModel.addRow(rowData);
                }
            }

            // take data from checkouts
            String selectCheckoutsQuery = "SELECT id, book_id, borrower_id, count_date, due_date  FROM checkouts";
            try (PreparedStatement stmt = conn.prepareStatement(selectCheckoutsQuery);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("id"),
                            rs.getInt("book_id"),
                            rs.getInt("borrower_id"),
                            rs.getString("count_date"),
                            rs.getString("due_date"),

                    };
                    checkoutModel.addRow(rowData);
                }
            }

            System.out.println("Tables refreshed successfully.");
        } catch (SQLException e) {
            System.err.println("Error refreshing tables: " + e.getMessage());
        }
        // bookModel.setRowCount(0);

        // try (Connection conn = DriverManager.getConnection(DB_URL)) {
        // String selectBooksQuery = "SELECT id, title, author, genre, publication_date,
        // isbn, available FROM books";
        // PreparedStatement selectBooksStmt = conn.prepareStatement(selectBooksQuery);
        // ResultSet bookResults = selectBooksStmt.executeQuery();
        // while (bookResults.next()) {
        // Object[] bookData = {
        // bookResults.getInt("id"),
        // bookResults.getString("title"),
        // bookResults.getString("author"),
        // bookResults.getString("genre"),
        // bookResults.getString("publication_date"),
        // bookResults.getString("isbn"),
        // bookResults.getBoolean("available")
        // };
        // bookModel.addRow(bookData);
        // }

        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
    }

}
