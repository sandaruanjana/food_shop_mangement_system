/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public interface OrderBO extends SuperBO{
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;

    public boolean purchaseOrder(OrderDTO order) throws ClassNotFoundException, SQLException;
    
    public ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException;
    
    public boolean payOrder(OrderDTO order) throws ClassNotFoundException, SQLException;
    
    public boolean cancelOrder(OrderDTO order) throws ClassNotFoundException, SQLException;
    
    public int allOrderPlaced()throws ClassNotFoundException, SQLException;
    
    public int allOrderCanceled()throws ClassNotFoundException, SQLException;
    
    
    
}
