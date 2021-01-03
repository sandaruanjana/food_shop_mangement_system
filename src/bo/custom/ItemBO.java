/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dao.SuperDAO;
import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public interface ItemBO extends SuperBO{
    public boolean addItem(ItemDTO item) throws ClassNotFoundException, SQLException;

    public boolean updateItem(ItemDTO item) throws ClassNotFoundException, SQLException;

    public boolean removeItem(String id) throws ClassNotFoundException, SQLException;

    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException;

    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException;
}
