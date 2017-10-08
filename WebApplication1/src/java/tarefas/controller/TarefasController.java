/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import tarefas.dao.TarefaDao;
import tarefas.model.Tarefa;

/**
 *
 * @author Alcides Lemos
 */
@Controller
public class TarefasController {

    @RequestMapping("novaTarefa")
    public String form() {
        return "tarefa/formulario";
    }

    @RequestMapping("adicionaTarefa")
    public String adicionar(@Valid Tarefa tarefa, BindingResult result) {
        if (result.hasFieldErrors("descricao")) {
            return "tarefa/formulario";
        } else if(result.hasErrors()) {
            return "tarefa/formulario";
        }
        
        TarefaDao dao = new TarefaDao();
        dao.adiciona(tarefa);
        return "tarefa/adicionada";
    }
    
    
    @RequestMapping("listaTarefas")
    public String lista(Model model) {
        TarefaDao dao = new TarefaDao();
        model.addAttribute("tarefas", dao.recuperarTodasTarefas());
        return "tarefa/lista";
    }
    
    @RequestMapping("removeTarefa")
    public String deletar(int id) {
        TarefaDao dao = new TarefaDao();
        dao.deletar(id);
        //return "forward:listaTarefas"; //Lado Servidor
        return "redirect:listaTarefas"; //Lado Cliente
    }
    
    @RequestMapping("mostraTarefa")
    public String mostra(int id, Model model) {
        TarefaDao dao = new TarefaDao();
        try {
            model.addAttribute("tarefa", dao.consultaPorID(id));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "tarefa/tarefa";
    }
    
    @RequestMapping("alteraTarefa")
    public String altera(Tarefa tarefa) {
        TarefaDao dao = new TarefaDao();
        System.out.println(tarefa);
        dao.altera(tarefa);
        return "redirect:listaTarefas";
    }
    
    @RequestMapping("teste")
    public String teste() {
        System.out.println("adasdas");
        TarefaDao dao = new TarefaDao();
        Tarefa teste = new Tarefa();
        teste.setDataFinalizacao("01/01/2001");
        teste.setDescricao("Desc");
        teste.setFinalizado(true);
        teste.setIdTarefa(1);
        dao.adiciona(teste);
        return "index";
    }
}
