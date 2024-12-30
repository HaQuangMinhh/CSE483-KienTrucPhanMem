/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problem1;

/**
 *
 * @author Admin
 */
public class Problem1 {

    public static void main(String[] args) {
       BankingController controller = new BankingController();

       
        controller.authenticateUser("John Smith", "password999099");

        
        controller.deposit("1001", 1000.0);
        
      
        controller.withdraw("1001", 500.0);
        
       
        controller.transactionLog("1001");  
        
        controller.withdraw("1002", 100.0); 
        controller.deposit("1003", 1000.0); 
    }
    }

