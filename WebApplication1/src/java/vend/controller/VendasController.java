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
public class VendasController {
    @RequestMapping("/")
    public String lista(Model model) {
        ProdDao dao = new ProdDao();
        model.addAttribute("produtos", dao.recuperarTodos());
        return "vend/index";
    }
    
    @RequestMapping("addCart")
    public void addCarrinho(ProdCart prod, HttpServletResponse response, HttpSession session){
        System.out.println("Add Cart");
        Cart carrinho = new Cart();
        if(session.getAttribute("carrinho") != null){
            carrinho.setCarrinho(((Cart) session.getAttribute("carrinho")).getCarrinho());
        } 
        prod.setQuantidade(prod.getQuantidade() + carrinho.quantCarrinho(prod.getProduto()));
        if (prod.getQuantidade() < 0){
            prod.setQuantidade(0);
        }
        carrinho.addCarrinho(prod);
        session.setAttribute("carrinho", carrinho);
        System.out.println(carrinho);
        response.setStatus(200);
    }
    
    
    @RequestMapping("vend")
    public String limparCarrinho(HttpSession session){
        session.removeAttribute("carrinho");
        
        return "redirect:index";
    }   
}
