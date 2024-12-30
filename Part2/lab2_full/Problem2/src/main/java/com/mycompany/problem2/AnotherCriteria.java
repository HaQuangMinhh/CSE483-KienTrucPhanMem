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
public class AnotherCriteria implements Criteria {
    
    private List<Criteria> criteriaList;

     public AnotherCriteriat(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public List<employee> meetCriteria(List<employee> employees) {
        List<employee> filteredEmployees = new ArrayList<>(employees); 
       
        for (Criteria criteria : criteriaList) {
            filteredEmployees = criteria.meetCriteria(filteredEmployees);
        }

        return filteredEmployees;
    }
}
