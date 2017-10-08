/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vend.model.Produto;

/**
 *
 * @author Alcides Lemos
 */
@Controller
public class CartController {
    /*
    @RequestMapping("addCart")
    public String addCarrinho(int produto, HttpSession session){
        ArrayList<Produto> carrinho = new ArrayList<>();
        //System.out.println("pqp, qual é o erro?");
        //session.getAttribute("carrinho");
        return "#";
    }*/
}
