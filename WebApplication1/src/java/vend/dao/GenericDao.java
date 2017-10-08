/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vend.conn.ConnGeneric;

/**
 *
 * @author Alcides Lemos
 */
public abstract class GenericDao {
    protected ConnGeneric conn;
    public String tabela;
    public GenericDao() {
        try {
            Class<?> classeDao = Class.forName("vend.conn." + ConnGeneric.nameDAO);
            conn = (ConnGeneric) classeDao.newInstance();
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar a classe tarefas.model." + ConnGeneric.nameDAO);
            e.printStackTrace();
        }
    }
    
    protected abstract Object construirObjeto(ResultSet rs);
    public abstract void adicionar(Object obj, String tabela);
    public abstract void altera(Object obj);
    public abstract ArrayList<Object> recuperarTodos();
    public void adicionar(Object obj){
        adicionar(obj,tabela);
    };
    public Object consultaPorID(int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj = null;

        try {
            ps = conn.getConnection().prepareStatement("SELECT * FROM " + tabela + " WHERE cod = ?");
            ps.setInt(1, id);
            rs = conn.getResultset(ps);
            if (rs.next()) {
                obj = construirObjeto(rs);
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage() );
        } finally {
            rs.close();
            ps.close();
        }
        return obj;
    }    
    
    void deletar (int id){
        try {
            deletar(id,tabela);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
    protected void deletar(int id, String nomeTabela) throws SQLException{
        PreparedStatement ps = null;
        try {
            ps = conn.getConnection().prepareStatement("DELETE FROM "+nomeTabela+" WHERE ID = ?");
            ps.setInt(1, id);
            conn.executeUpdate(ps);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            ps.close();
        }    
    }
    
    
    public ArrayList<Object> recuperarListaDeObjetos(String sql) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Object> lista = new ArrayList<Object>();
        try{
            ps = conn.getConnection().prepareStatement(sql);
            rs = conn.getResultset(ps);
            while (rs.next()) {
                lista.add(construirObjeto(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
        }
        return lista;
    }
}
