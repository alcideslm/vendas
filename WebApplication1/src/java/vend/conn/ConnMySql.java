/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alcides Lemos
 */
public class ConnMySql extends ConnGeneric{
    private static final String DBURL = "jdbc:mysql://localhost/banco";
    private static final String USER = "root";
    private static final String PASS = "182950";
    
    
    public ConnMySql(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    @Override
    public Connection getConnection() {
        if (conn == null){
            try {
                conn = (Connection) DriverManager.getConnection(DBURL,USER,PASS);
                System.out.println("Conectou com Servidor MySql!!");
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
        return conn;
    }
}
