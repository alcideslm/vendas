/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vend.dao.ClienteDao;
import vend.model.Cliente;

/**
 *
 * @author Alcides Lemos
 */
@Controller
public class LoginController{
    @RequestMapping("loginForm")
    public String loginForm() {
        return "loginForm";
    }
    
    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Cliente cliente, HttpSession session) {
        if(new ClienteDao().existeCliente(cliente)) {
            session.setAttribute("usuarioLogado", cliente);
            return "redirect:cart";
        }
        return "redirect:loginForm";
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

  @RequestMapping("fLogin")
  public String formLogin() {
      return "loginForm";
  }
}

