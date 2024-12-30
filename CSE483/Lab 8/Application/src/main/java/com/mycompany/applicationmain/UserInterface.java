/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applicationmain;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
class UserInterface {
    private final FileWriterModule fileWriter;
    private final CompressionModule compressor;
    private final EncryptionModule encryptor;

    public UserInterface() {
        fileWriter = new FileWriterModule();
        compressor = new CompressionModule();
        encryptor = new EncryptionModule();
    }

    public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    handleFileWriting(scanner);
                    break;
                case 2:
                    handleCompression(scanner);
                    break;
                case 3:
                    handleEncryption(scanner);
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Screaming Architecture App ---");
        System.out.println("1. Write data to file");
        System.out.println("2. Compress data");
        System.out.println("3. Encrypt data");
        System.out.println("4. Exit");
    }

    private void handleFileWriting(Scanner scanner) {
        System.out.print("Enter data to write: ");
        String data = scanner.nextLine();
        System.out.print("Enter file format (CSV, JSON, XML): ");
        String format = scanner.nextLine();
        try {
            fileWriter.writeToFile(data, format, "output");
        } catch (Exception e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    private void handleCompression(Scanner scanner) {
        System.out.print("Enter data to compress: ");
        String data = scanner.nextLine();
        String compressed = compressor.compressData(data);
        System.out.println("Compressed data: " + compressed);
    }

    private void handleEncryption(Scanner scanner) {
        System.out.print("Enter data to encrypt: ");
        String data = scanner.nextLine();
        String encrypted = encryptor.encryptData(data);
        System.out.println("Encrypted data: " + encrypted);
    }
}
