/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapp;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
class OrderLineItem {
    private Long orderLineId;
    private String orderLineSkuCode;
    private BigDecimal productPrice;
    private Integer quantity;

   
    public OrderLineItem(Long orderLineId, String orderLineSkuCode, BigDecimal productPrice, Integer quantity) {
        this.orderLineId = orderLineId;
        this.orderLineSkuCode = orderLineSkuCode;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public Long getOrderLineId() { return orderLineId; }
    public void setOrderLineId(Long orderLineId) { this.orderLineId = orderLineId; }
    public String getOrderLineSkuCode() { return orderLineSkuCode; }
    public void setOrderLineSkuCode(String orderLineSkuCode) { this.orderLineSkuCode = orderLineSkuCode; }
    public BigDecimal getProductPrice() { return productPrice; }
    public void setProductPrice(BigDecimal productPrice) { this.productPrice = productPrice; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
