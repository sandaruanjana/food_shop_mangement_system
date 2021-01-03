/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class ItemController {
    
    ItemBO bo = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    
    public boolean addItem(ItemDTO item) throws ClassNotFoundException, SQLException {
        return bo.addItem(item);
    }
    
    public boolean updateItem(ItemDTO item) throws ClassNotFoundException, SQLException {
        return bo.updateItem(item);
    }
    
    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException {
        return bo.removeItem(id);
    }
    
    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException {
        return bo.searchItem(id);
    }
    
    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException {
        return bo.getAllItems();
    }
    
    
}
