/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.layeredarchitecture;

/**
 *
 * @author Admin
 */
public class LayeredArchitecture {

    public static void main(String[] args) {
        Database database = new Database();
        LibraryManager libraryManager = new LibraryManager(database);
        LibraryUI ui = new LibraryUI(libraryManager);
        ui.start();
    }
    }

