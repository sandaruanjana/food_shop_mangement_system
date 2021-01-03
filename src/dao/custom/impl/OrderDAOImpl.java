/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;
import entity.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(Orders e) throws ClassNotFoundException, SQLException {
        String sql = "insert into Orders values(?,?,?,?,?,CURRENT_TIMESTAMP)";
        return CrudUtil.executeUpdate(sql, e.getOrder_id(), e.getCid(), e.getOrder_type(), e.getStatus(), e.getPayment());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return true;
    }

    @Override
    public boolean update(Orders e) throws ClassNotFoundException, SQLException {
        String sql = "Update orders set payment='Paid' where order_id=?";
        return CrudUtil.executeUpdate(sql, e.getOrder_id());
    }

    @Override
    public Orders search(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.excuteQuery("SELECT * FROM ORDERS where payment='Pending' and status='Confirm'  ORDER BY order_id DESC");
        ArrayList<Orders> allOrders = new ArrayList<>();
        while (rst.next()) {
            int orderID = rst.getInt(1);
            int cid = rst.getInt(2);
            String orderType = rst.getString(3);
            String status = rst.getString(4);
            String payment = rst.getString(5);

            Orders order = new Orders(orderID, cid, orderType, status, payment);
            allOrders.add(order);

        }
        return allOrders;
    }

    @Override
    public boolean cancelOrder(Orders e) throws ClassNotFoundException, SQLException {
        String sql = "Update orders set status='Cancel' where order_id=?";
        return CrudUtil.executeUpdate(sql, e.getOrder_id());
    }

    @Override
    public int allOrderPlaced() throws ClassNotFoundException, SQLException {
        String sql = "select count(order_id) from orders where status='Confirm'";
        int allOrderPlace = 0;
        ResultSet rst = CrudUtil.excuteQuery(sql);
        if (rst.next()) {
            allOrderPlace = rst.getInt(1);
        }
        return allOrderPlace;
    }

    @Override
    public int allOrderCanceled() throws ClassNotFoundException, SQLException {
        String sql = "select count(order_id) from orders where status='Cancel'";
        int allOrderPlace = 0;
        ResultSet rst = CrudUtil.excuteQuery(sql);
        if (rst.next()) {
            allOrderPlace = rst.getInt(1);
        }
        return allOrderPlace;
    }

}
