/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem2;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InformationSort {
     public static void sortByName(List<employee> employees) {
        employees.sort(Comparator.comparing(employee::getName));
    }

    public static void sortByDepartment(List<employee> employees) {
        employees.sort(Comparator.comparing(employee::getDepartment));
    }

    public static void sortBySalary(List<employee> employees) {
        employees.sort(Comparator.comparingDouble(employee::getSalary));
    }
}

