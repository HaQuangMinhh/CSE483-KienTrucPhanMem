/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problem2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Problem2 {

    public static void main(String[] args) {
         List<employee> employees = Arrays.asList(
            new employee("john", "Engineering", "Developer", 5, 70000, Arrays.asList("Java", "Spring")),
            new employee("Austin", "Data Analyst", "Developer", 2, 50000, Arrays.asList("Python", "Django")),
            new employee("Charlie", "HR", "Manager", 10, 90000, Arrays.asList("Leadership", "Communication")),
            new employee("Dave", "Sales", "Executive", 3, 60000, Arrays.asList("Negotiation", "Salesforce"))
        );

      
        Criteria engineeringCriteria = new DepartmentCriteria("Engineering");
        Criteria minExperienceCriteria = (Criteria) new ExperienceCriteria(3);
        Criteria javaSkillCriteria = (Criteria) new SkillsCriteria("Java");

        Criteria combinedCriteria = new AnotherCriteria(Arrays.asList(engineeringCriteria, minExperienceCriteria, javaSkillCriteria));

     
        List<employee> filteredEmployees = combinedCriteria.meetCriteria(employees);


       
        System.out.println("Filtered Employees:");
        for (employee employee : filteredEmployees) {
            System.out.println(employee.getName());
        }

      
        InformationSort.sortBySalary(filteredEmployees);
        System.out.println("\nEmployees sorted by salary:");
        for (employee employee : filteredEmployees) {
            System.out.println(employee.getName() + " - $" + employee.getSalary());
        }
    }
    }


