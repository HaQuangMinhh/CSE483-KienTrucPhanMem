/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapp;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Order {
   private Long orderId;
    private String orderNumber;
    private List<OrderLineItem> orderLineItems;

    
    public Order(Long orderId, String orderNumber, List<OrderLineItem> orderLineItems) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.orderLineItems = orderLineItems;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public List<OrderLineItem> getOrderLineItems() { return orderLineItems; }
    public void setOrderLineItems(List<OrderLineItem> orderLineItems) { this.orderLineItems = orderLineItems; }  
}
