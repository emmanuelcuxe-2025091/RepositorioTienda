package com.emmanuelcuxe.Tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String mostrarHome () {
        return "home";
    }

    @GetMapping("/clientes")
    public String mostrarClientes () {
        return "clientes";
    }

    @GetMapping("/usuarios")
    public String mostrarUsuarios () {
        return "usuarios";
    }
}