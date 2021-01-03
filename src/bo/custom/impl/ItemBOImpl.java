/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class ItemBOImpl implements ItemBO{
    
    ItemDAO itemDAO=(ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO i) throws ClassNotFoundException, SQLException {
        return itemDAO.add(new Item(0, i.getName(), i.getPrice(), i.getQty()));
    }

    @Override
    public boolean updateItem(ItemDTO i) throws ClassNotFoundException, SQLException {
        return itemDAO.update(new Item(i.getId(), i.getName(), i.getPrice(), i.getQty()));
    }

    @Override
    public boolean removeItem(String id) throws ClassNotFoundException, SQLException {
        return itemDAO.delete(id);
    }

    @Override
    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item i : all) {
            allItems.add(new ItemDTO(i.getId(),i.getName(),i.getPrice(),i.getQty()));
        }
        return allItems;
    }
    
}
