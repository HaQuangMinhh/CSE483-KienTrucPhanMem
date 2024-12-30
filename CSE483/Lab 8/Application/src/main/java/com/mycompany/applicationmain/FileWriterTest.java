/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applicationmain;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FileWriterTest {
    public void testWriteToFile() {
        FileWriterModule fileWriter = new FileWriterModule();
        try {
            fileWriter.writeToFile("Sample Data", "txt", "test_output");
            System.out.println("File writing test passed.");
        } catch (IOException e) {
            System.err.println("File writing test failed: " + e.getMessage());
        }
    }
}
