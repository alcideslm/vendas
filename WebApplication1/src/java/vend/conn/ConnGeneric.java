/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alcides Lemos
 */
public abstract class ConnGeneric {

    public static final String nameDAO = "ConnPostgres";
    //public static final String nameDAO = "ConnMySql";

    protected static Connection conn;
    
    public abstract Connection getConnection();

    public int executeUpdate(PreparedStatement consulta) throws SQLException {
        return consulta.executeUpdate();
    }
    
    public ResultSet getResultset (PreparedStatement consulta) throws SQLException{
        return consulta.executeQuery();
    }
}
