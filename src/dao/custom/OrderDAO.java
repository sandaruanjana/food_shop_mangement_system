/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom;

import dao.CrudDAO;
import entity.Orders;
import java.sql.SQLException;

/**
 *
 * @author Sandaru
 */
public interface OrderDAO extends CrudDAO<Orders, String>{
    
    public boolean cancelOrder(Orders e) throws ClassNotFoundException, SQLException;
    
    public int allOrderPlaced() throws ClassNotFoundException, SQLException;
    public int allOrderCanceled()throws ClassNotFoundException, SQLException;
    
        
    
}
