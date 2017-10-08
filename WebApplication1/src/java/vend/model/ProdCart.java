/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.model;

import java.io.Serializable;

/**
 *
 * @author Alcides Lemos
 */
public class ProdCart implements Serializable{
    private int produto,
                quantidade;

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return(produto + ": " + quantidade + " itens\n");
    }
    
    
    
}