/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem2;

import java.util.List;

/**
 *
 * @author Admin
 */
public class employee {
     private String name;
    private String department;
    private String role;
    private int experience; 
    private double salary;
    private List<String> skills;

    public employee(String name, String department, String role, int experience, double salary, List<String> skills) {
        this.name = name;
        this.department = department;
        this.role = role;
        this.experience = experience;
        this.salary = salary;
        this.skills = skills;
    }

   
    public String getName() 
    { 
        return name; 
    }
    public String getDepartment() 
    { 
        return department; 
    }
    public String getRole() 
    { 
        return role;
        
    }
    public int getExperience() 
    { 
        return experience; 
    }
    public double getSalary() 
    { 
        return salary; 
    }
    public List<String> getSkills() 
    { 
        return skills; 
    }
}


