/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;

/**
 *
 * @author asaad
 */
public class DbConnection {
    
    
    private static Connection conn = null;
    
    private DbConnection(){};
    
    public static Connection getInstance(){
       
        if(conn == null){
            try {
              makeConnection();
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coaching_mangm","root","12345");       
            } catch (Exception ex) {
                ex.printStackTrace();
                //new MessageForm("Error",ex.toString(),"error.png");
            }
        }
        
        return conn;
    }
    
    private static void makeConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public static void closeConnection() throws Exception {
        if(conn == null){
             conn.close();
        }
    }
    
}
