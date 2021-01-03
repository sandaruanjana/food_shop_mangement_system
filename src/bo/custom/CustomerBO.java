/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public interface CustomerBO extends SuperBO{
    public boolean add(CustomerDTO entity) throws ClassNotFoundException,SQLException;
    public boolean delete(String id) throws ClassNotFoundException,SQLException;
    public boolean update(CustomerDTO entity) throws ClassNotFoundException,SQLException;
    public CustomerDTO search(String id) throws ClassNotFoundException,SQLException;
    public ArrayList<CustomerDTO> getAll() throws ClassNotFoundException,SQLException;
    
}
