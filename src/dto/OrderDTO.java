/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class OrderDTO {
    int order_id;
    int cid;
    String order_type;
    String status;
    String payment;
    private ArrayList<OrderDetailDTO> orderDetails = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(int order_id) {
        this.order_id = order_id;
    }
    
    

    public OrderDTO(int order_id, int cid, String order_type, String status, String payment) {
        this.order_id = order_id;
        this.cid = cid;
        this.order_type = order_type;
        this.status = status;
        this.payment = payment;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public ArrayList<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

   
    
    
}
