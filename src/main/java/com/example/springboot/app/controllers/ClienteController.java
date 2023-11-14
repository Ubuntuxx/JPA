package com.example.springboot.app.controllers;

import com.example.springboot.app.models.dao.IClienteDao;
import com.example.springboot.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {
    @Autowired
    private IClienteDao clienteDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "listar clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }

    @RequestMapping(value="/form")
    public String crear(Model model){
	Cliente cliente = new Cliente();
	model.addAttribute("cliente", cliente);
	model.addAttribute("titulo", "Formulario de cliente");
	return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String guardar(Cliente cliente) {
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}
