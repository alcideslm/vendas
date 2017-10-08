/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vend.model.Produto;

/**
 *
 * @author Alcides Lemos
 */
public class ProdDao extends GenericDao{
    private static ProdDao instance;
    public static ProdDao getInsance() {
        if (instance == null) {
            instance = new ProdDao();
        }
        return instance;
    }

    public ProdDao() {
        super();
        super.tabela = "produto";
    }
    
    @Override
    protected Object construirObjeto(ResultSet rs) {
        Produto prod = new Produto();
        try {
            prod.setCod(rs.getInt("cod"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setNome(rs.getString("nome"));
            prod.setValor(rs.getDouble("valor"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return prod;
    }

    @Override
    public void adicionar(Object obj, String tabela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altera(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> recuperarTodos() {
        ArrayList<Object> produtos = null;
        try {
             produtos = super.recuperarListaDeObjetos("select * from produto");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }
}
