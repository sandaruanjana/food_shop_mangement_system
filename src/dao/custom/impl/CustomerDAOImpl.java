/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer e) throws ClassNotFoundException, SQLException {
        String sql = "insert into Customer values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, e.getCid(), e.getName(), e.getAddress(), e.getTel(), e.getGender());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        
        String sql = "Delete from Customer where cid=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public boolean update(Customer e) throws ClassNotFoundException, SQLException {
        
        String sql = "Update Customer set name=?,address=?,tel=?,gender=? where cid=?";
        return CrudUtil.executeUpdate(sql, e.getName(), e.getAddress(), e.getTel(), e.getGender(), e.getCid());
    }

    @Override
    public Customer search(String id) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Customer where tel=?";
        ResultSet rst = CrudUtil.excuteQuery(sql, id);
        if (rst.next()) {
            int cid = rst.getInt(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            int number = rst.getInt(4);
            String gender = rst.getString(5);

            return new Customer(cid, name, address, number, gender);
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Customer";
        ResultSet rst = CrudUtil.excuteQuery(sql);
        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()) {

            int cid = rst.getInt(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            int number = rst.getInt(4);
            String gender = rst.getString(5);
            
            Customer customer = new Customer(cid, name, address, number, gender);
            
            allCustomer.add(customer);

        }
        return allCustomer;
    }

}
