/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Sandaru
 */
public class OrderDetailDTO {
    int orderdetail_id;
    int order_id;
    int item_id;
    int qty;
    double unit_price;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderdetail_id, int order_id, int item_id, int qty, double unit_price) {
        this.orderdetail_id = orderdetail_id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.qty = qty;
        this.unit_price = unit_price;
    }

    public int getOrderdetail_id() {
        return orderdetail_id;
    }

    public void setOrderdetail_id(int orderdetail_id) {
        this.orderdetail_id = orderdetail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    
    
}
