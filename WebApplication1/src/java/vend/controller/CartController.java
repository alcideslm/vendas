/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vend.dao.ProdDao;
import vend.model.Cart;
import vend.model.ProdCart;
import vend.model.Produto;

/**
 *
 * @author Alcides Lemos
 */
@Controller
public class CartController {
    @RequestMapping("cart")
    public String cart(Model model, HttpSession session) {
        Cart carrinho = new Cart();
        ProdDao dao = new ProdDao();
        ArrayList<Produto> produtos = new ArrayList();
        if(session.getAttribute("carrinho") != null){
            int itens = 0;
            carrinho.setCarrinho(((Cart) session.getAttribute("carrinho")).getCarrinho());
            itens = carrinho.getCarrinho().size();
            for (ProdCart p : carrinho.getCarrinho()){
                try {
                    Produto prod = (Produto) dao.consultaPorID(p.getProduto());
                    prod.setQuantidade(p.getQuantidade());
                    produtos.add(prod);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } 
        model.addAttribute("carrinho", produtos);
        return "vend/cart";
    }
}
