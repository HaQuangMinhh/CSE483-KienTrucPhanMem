/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem2;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class DepartmentCriteria implements Criteria {
    private String department;

    public DepartmentCriteria(String department) {
        this.department = department;
    }

    @Override
    public List<employee> meetCriteria(List<employee> employees) {
        List<employee> filteredEmployees = new ArrayList<>();

        for (employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                filteredEmployees.add(employee);
            }
        }
        
        return filteredEmployees;
    }
}

