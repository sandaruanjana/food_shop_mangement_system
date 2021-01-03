/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailsDAO;
import dao.custom.impl.OrderDAOImpl;
import db.DBConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class OrderBOImpl implements OrderBO {

    int oid;

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    OrderDetailsDAO orderDetailDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {

        Customer s = customerDAO.search(id);
        return new CustomerDTO(s.getCid(), s.getName(), s.getAddress(), s.getTel(), s.getGender());
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item s = itemDAO.search(code);
        return new ItemDTO(s.getId(), s.getName(), s.getPrice(), s.getQty());
    }

    @Override
    public boolean purchaseOrder(OrderDTO dto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Orders order = new Orders(0, dto.getCid(), dto.getOrder_type(), dto.getStatus(), dto.getPayment());

        boolean add = orderDAO.add(order);
        if (add) {

            ArrayList<Orders> all = new OrderDAOImpl().getAll();
            for (Orders orders : all) {
                oid = orders.getOrder_id();
            }

            for (OrderDetailDTO od : dto.getOrderDetails()) {
                OrderDetail orderDetail = new OrderDetail(0,oid,od.getItem_id(),od.getQty(),od.getUnit_price());
                boolean add1 = orderDetailDAO.add(orderDetail);
                
                if (!add1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;

                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }
        connection.rollback();
        connection.setAutoCommit(true);
        return false;

    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException {
        ArrayList<Orders> all = orderDAO.getAll();
        ArrayList<OrderDTO> allOrders=new ArrayList<>();
        for (Orders o : all) {
            allOrders.add(new OrderDTO(o.getOrder_id(), o.getCid(), o.getOrder_type(), o.getStatus(), o.getPayment()));
        }
            return allOrders;
    }

    @Override
    public boolean payOrder(OrderDTO o) throws ClassNotFoundException, SQLException {
            return orderDAO.update(new Orders(o.getOrder_id(), o.getCid(), o.getOrder_type(), o.getStatus(), o.getPayment()));
    }

    @Override
    public boolean cancelOrder(OrderDTO o) throws ClassNotFoundException, SQLException {
        return orderDAO.cancelOrder(new Orders(o.getOrder_id(), o.getCid(), o.getOrder_type(), o.getStatus(), o.getPayment()));
    }

    @Override
    public int allOrderPlaced() throws ClassNotFoundException, SQLException {
        return orderDAO.allOrderPlaced();
    }

    @Override
    public int allOrderCanceled() throws ClassNotFoundException, SQLException {
        return orderDAO.allOrderCanceled();
    }

}
