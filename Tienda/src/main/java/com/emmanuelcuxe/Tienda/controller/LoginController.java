package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import com.emmanuelcuxe.Tienda.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarLogin () {
        return "login";
    }

    @PostMapping("/loginI")
    public String login(@RequestParam String username,
                        @RequestParam String contrasena,
                        HttpSession session,
                        Model model) {

        Usuarios u = service.login(username, contrasena);

        if (u != null) {
            session.setAttribute("usuarioLogueado", u.getUsername());
            session.setAttribute("rolUsuario", u.getRol());
            session.setAttribute("fotoUsuario", u.getRol().equals("admin")
                    ? "/images/Admin.jpg"
                    : "/images/User.png");
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String username,
                          @RequestParam String contrasena,
                          @RequestParam String rol,
                          Model model) {

        Usuarios u = service.registrar(username, contrasena, rol);

        if (u == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }
        return "redirect:/login";
    }

    // LISTA
    @GetMapping("/lista")
    public String listar(Model model) {
        List<Usuarios> lista = service.listar();
        model.addAttribute("usuarios", lista);
        return "lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/lista";
    }
}