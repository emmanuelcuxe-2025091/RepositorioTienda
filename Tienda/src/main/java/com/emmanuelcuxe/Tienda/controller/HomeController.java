package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.*;
import com.emmanuelcuxe.Tienda.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private ProductosService productosService;

    @Autowired
    private VentasService ventasService;

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/home")
    public String mostrarHome () {
        return "home";
    }

    @GetMapping("/home/seccion/clientes")
    @ResponseBody
    public String seccionClientes(Model model) {

        List<Clientes> lista = clientesService.getAllClientes();
        model.addAttribute("clientes", lista);

        return templateEngine.process("fragments/clientes",
                new Context(LocaleContextHolder.getLocale(), model.asMap()));
    }

    @GetMapping("/home/seccion/usuarios")
    @ResponseBody
    public String seccionUsuarios(Model model) {

        List<Usuarios> lista = usuariosService.getAllUsuarios();
        model.addAttribute("usuarios", lista);

        return templateEngine.process("fragments/usuarios",
                new Context(LocaleContextHolder.getLocale(), model.asMap()));
    }

    @GetMapping("/home/seccion/productos")
    @ResponseBody
    public String seccionProductos(Model model) {

        List<Productos> lista = productosService.getAllProductos();
        model.addAttribute("productos", lista);

        return templateEngine.process("fragments/productos",
                new Context(LocaleContextHolder.getLocale(), model.asMap()));
    }

    @GetMapping("/home/seccion/ventas")
    @ResponseBody
    public String seccionVentas(Model model) {

        List<Ventas> lista = ventasService.getAllVentas();
        model.addAttribute("ventas", lista);

        return templateEngine.process("fragments/ventas",
                new Context(LocaleContextHolder.getLocale(), model.asMap()));
    }

    @GetMapping("/home/seccion/detalleVenta")
    @ResponseBody
    public String seccionDetalleVenta(Model model) {

        List<DetalleVenta> lista = detalleVentaService.getAllDetalleVenta();
        model.addAttribute("detalleVenta", lista);

        return templateEngine.process("fragments/detalleVenta",
                new Context(LocaleContextHolder.getLocale(), model.asMap()));
    }
}