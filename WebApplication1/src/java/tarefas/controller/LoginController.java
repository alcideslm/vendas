/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tarefas.dao.UsuarioDao;
import tarefas.model.Usuario;

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
    public String efetuaLogin(Usuario usuario, HttpSession session) {
        if(new UsuarioDao().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "menu";
        }
        return "redirect:loginForm";
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
}
