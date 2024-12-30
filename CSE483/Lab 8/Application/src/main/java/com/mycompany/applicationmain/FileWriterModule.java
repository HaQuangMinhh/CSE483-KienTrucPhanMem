/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applicationmain;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FileWriterModule {
   public void writeToFile(String data, String format, String fileName) throws IOException {
        String filePath = fileName + "." + format.toLowerCase();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
            System.out.println("Data successfully written to " + filePath);
        }
    }  
}
