/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.application;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FileWriterModule {
     public void writeToFile(String data, String format, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath + "." + format.toLowerCase())) {
            writer.write(data);
            System.out.println("Data written to " + filePath + "." + format.toLowerCase());
        }
    }
}
