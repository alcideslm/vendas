/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vend.model.Cliente;

/**
 *
 * @author Alcides Lemos
 */
public class ClienteDao extends GenericDao{
    
    private static ClienteDao instance;
    public static ClienteDao getInsance() {
        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }

    public ClienteDao() {
        super();
        super.tabela = "cliente";
    }
    
    public boolean existeCliente(Cliente cliente) {
        Cliente clientedb;
        try {
            clientedb = (Cliente) consultaPorEmail(cliente.getEmail());
            System.out.println("Senha: " + cliente.getSenha());
            System.out.println("SenhaDB: " + clientedb.getSenha());
            System.out.println("" + clientedb.getSenha().equals(cliente.getSenha()));
            return clientedb.getSenha().trim().equals(cliente.getSenha().trim());
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente no banco.");
            System.out.println(ex.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Object consultaPorEmail(String email) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj = null;

        try {
            ps = conn.getConnection().prepareStatement("SELECT * FROM " + tabela + " WHERE email = '" + email + "'");
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

    @Override
    protected Object construirObjeto(ResultSet rs) {
        Cliente cliente = new Cliente();
        try {
            cliente.setCod(rs.getInt("cod"));
            cliente.setSenha(rs.getString("senha"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return cliente;
    }

    @Override
    public void adicionar(Object obj, String tabela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altera(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
