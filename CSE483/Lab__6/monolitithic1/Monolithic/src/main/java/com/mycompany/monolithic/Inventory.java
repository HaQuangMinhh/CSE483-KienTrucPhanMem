/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.monolithic;
/**
 *
 * @author Admin
 */
public class Inventory {
     private Long invId;
    private Long productId;
    private Integer quantity;

    public Inventory(Long invId, Long productId, Integer quantity) {
        this.invId = invId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getInvId() { return invId; }
    public void setInvId(Long invId) { this.invId = invId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}


