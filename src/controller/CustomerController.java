/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class CustomerController {

    CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    public boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return bo.add(customer);
    }

    public boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return bo.update(customer);
    }

    public boolean removeCustomer(String customerID) throws ClassNotFoundException, SQLException {

        return bo.delete(customerID);
    }

    public CustomerDTO searchCustomer(String customerID) throws ClassNotFoundException, SQLException {
        return bo.search(customerID);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        return bo.getAll();
    }

}
