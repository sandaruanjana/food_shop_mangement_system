/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.OrderBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class OrderController {

    OrderBO bo = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);

    public CustomerDTO searchCustomer(int id) throws SQLException, ClassNotFoundException {
        return bo.searchCustomer(String.valueOf(id));
    }

    public ItemDTO searchItem(int id) throws SQLException, ClassNotFoundException {
        return bo.searchItem(String.valueOf(id));
    }

    public boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return bo.purchaseOrder(dto);
    }

    public ArrayList<OrderDTO> getAllOrders() throws ClassNotFoundException, SQLException {
       return bo.getAllOrders();
    }
    
    public boolean payOrder(OrderDTO dto)throws ClassNotFoundException, SQLException {
        return bo.payOrder(dto);
    }
    
    public boolean cancelOrder(OrderDTO dto)throws ClassNotFoundException, SQLException {
        return bo.cancelOrder(dto);
    }
    
    public int allOrderPlaced()throws ClassNotFoundException, SQLException {
        return bo.allOrderPlaced();
    }
    
    public int allOrderCanceled()throws ClassNotFoundException, SQLException {
        return bo.allOrderCanceled();
    }

}
