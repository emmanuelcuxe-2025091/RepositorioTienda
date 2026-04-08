package com.emmanuelcuxe.Tienda.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarLogin () {
        return "login";
    }

    @PostMapping("/loginI")
    public String login (@RequestParam String usuario,
                         @RequestParam String password,
                         HttpSession session,
                         Model model) {
        String userCorrecto = "e";
        String passCorrecto = "1";

        if (usuario.equals(userCorrecto) && password.equals(passCorrecto)) {
            //guardar sesion
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "usuario y contraseña incorrectos");
            return "login";
        }
    }

}