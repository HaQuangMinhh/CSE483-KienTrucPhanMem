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
public class SkillsCriteria {
   private String skill;

    public SkillsCriteria(String skill) {
        this.skill = skill;
    }

    public List<employee> meetCriteria(List<employee> employees) {
        List<employee> filteredEmployees = new ArrayList<>();

        
        for (employee employee : employees) {
            if (employee.getSkills().contains(skill)) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }   
}
