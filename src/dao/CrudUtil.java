/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sandaru
 */
public class CrudUtil {
    
    private static PreparedStatement getPreparedStatement(String sql,Object... params) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            pst.setObject((i+1), params[i]);
        }
        return pst;
    }
    
    public static boolean executeUpdate(String sql,Object... params) throws SQLException, ClassNotFoundException{
        return getPreparedStatement(sql, params).executeUpdate()>0;
    }
    
    public static ResultSet excuteQuery(String sql,Object... params) throws SQLException, ClassNotFoundException{
        return getPreparedStatement(sql, params).executeQuery();
    }
    
}