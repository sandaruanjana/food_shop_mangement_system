/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.BOFactory;
import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class CustomerBOImpl implements CustomerBO {

    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean add(CustomerDTO e) throws ClassNotFoundException, SQLException {
        return dao.add(new Customer(0, e.getName(), e.getAddress(), e.getTel(), e.getGender()));

    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    @Override
    public boolean update(CustomerDTO e) throws ClassNotFoundException, SQLException {
        
        return dao.update(new Customer(e.getCid(), e.getName(), e.getAddress(), e.getTel(), e.getGender()));
    }

    @Override
    public CustomerDTO search(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Customer> all = dao.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getCid(),c.getName(),c.getAddress(),c.getTel(),c.getGender()));
        }
        return allCustomers;
    }

}
