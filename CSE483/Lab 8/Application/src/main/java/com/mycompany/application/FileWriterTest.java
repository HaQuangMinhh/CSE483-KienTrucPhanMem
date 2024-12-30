/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.application;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FileWriterTest {

    public void testWriteToFile() {
        FileWriterModule fileWriter = new FileWriterModule();
        try {
            fileWriter.writeToFile("Test Data", "txt", "testfile");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Test failed: " + e.getMessage());
        }
    }
}
