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
import vend.model.Cliente;
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
                    ex.getStackTrace();
                }
            }
        } 
        model.addAttribute("carrinho", produtos);
        return "vend/cart";
    }
    
    @RequestMapping("limparCarrinho")
    public String limparCarrinho(HttpSession session){
        session.removeAttribute("carrinho");
        return "redirect:cart";
    }   
    
    @RequestMapping("finalizarCompra")
    public String enviarPedido(HttpSession session) {
        Cliente cli = (Cliente) session.getAttribute("usuarioLogado");
        
        String  loginEmail = "",
                senhaEmail = "";
        
        Cart carrinho = new Cart();
        ProdDao dao = new ProdDao();
        ArrayList<Produto> pedido = new ArrayList();
        String mail = "PEDIDO CONCLUIDO COM SUCESSO!\n\n";
        if(session.getAttribute("carrinho") == null){
            return "vend/pedidos";
        } else {
            carrinho.setCarrinho(((Cart) session.getAttribute("carrinho")).getCarrinho());
            for (ProdCart p : carrinho.getCarrinho()){
                try {
                    Produto prod = (Produto) dao.consultaPorID(p.getProduto());
                    prod.setQuantidade(p.getQuantidade());
                    pedido.add(prod);
                    mail += prod + "\n\n";
                    session.removeAttribute("carrinho");
                } catch (SQLException ex) {
                    ex.getStackTrace();
                }
            }
        }
        JavaMailApp teste = new JavaMailApp(loginEmail, senhaEmail);
        teste.enviarEmail(cli.getEmail(),mail);
        return "redirect:./";
    }
}
