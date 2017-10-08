/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alcides Lemos
 */
public class Cart implements Serializable{
    private ArrayList<ProdCart> carrinho = new ArrayList<>();

    public ArrayList<ProdCart> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<ProdCart> carrinho) {
        this.carrinho = carrinho;
    }
    
    public void addDireto(ProdCart produto){
        carrinho.add(produto);
    }
    
    public void addCarrinho(ProdCart produto){
        if (!carrinho.isEmpty()){
            for (int i = 0; i < carrinho.size(); i++) {
                if (carrinho.get(i).getProduto() == produto.getProduto()){
                    carrinho.remove(i);
                }
            }
        }
        carrinho.add(produto);
    }
    
    public int quantCarrinho(int id){
        for (ProdCart p : carrinho) {
            if (p.getProduto() == id){
                return p.getQuantidade();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String str = "";
        str = carrinho.stream().map((p) -> p.toString()).reduce(str, String::concat);
        return str;
    }
    
    
}
