/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.application;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Application {

    public static void main(String[] args) {
           UserInterface ui = new UserInterface();
        FileWriterModule fileWriter = new FileWriterModule();
        CompressionModule compressor = new CompressionModule();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            ui.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter data to write: ");
                    String data = scanner.nextLine();
                    System.out.print("Enter file format (CSV/JSON/XML): ");
                    String format = scanner.nextLine();
                    try {
                        fileWriter.writeToFile(data, format, "output");
                    } catch (Exception e) {
                        System.err.println("Error writing file: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter data to compress: ");
                    String compressData = scanner.nextLine();
                    String compressed = compressor.compressData(compressData);
                    System.out.println("Compressed Data: " + compressed);
                    break;
                case 3:
                    System.out.println("Encryption Module under development.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Application Exited.");
    }
    }

