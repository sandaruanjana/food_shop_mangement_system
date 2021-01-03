/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sandaru
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item e) throws ClassNotFoundException, SQLException {
        String sql = "insert into Item values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql, e.getId(), e.getName(), e.getPrice(), e.getQty());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Item where item_id=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public boolean update(Item e) throws ClassNotFoundException, SQLException {
        String sql = "Update Item set name=?,unit_price=?,qty=? where item_id=?";
        return CrudUtil.executeUpdate(sql, e.getName(),e.getPrice(),e.getQty(),e.getId());

    }

    @Override
    public Item search(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from Item where item_id=?";
        ResultSet rst = CrudUtil.excuteQuery(sql, id);
        if (rst.next()) {
            int item_id = Integer.parseInt(rst.getString(1));
            String itemName = rst.getString(2);
            double unitPrice = rst.getDouble(3);
            int qty = rst.getInt(4);
            
            return new Item(item_id, itemName, unitPrice, qty);
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Item";
        ResultSet rst = CrudUtil.excuteQuery(sql);
        ArrayList<Item> allItmes = new ArrayList<>();
        while (rst.next()) {
            int item_id = Integer.parseInt(rst.getString(1));
            String itemName = rst.getString(2);
            double unitPrice = rst.getDouble(3);
            int qty = rst.getInt(4);
            Item item = new Item(item_id, itemName, unitPrice, qty);
            allItmes.add(item);

        }
        return allItmes;
    }

}
