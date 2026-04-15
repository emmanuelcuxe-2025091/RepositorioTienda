package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    Usuarios registrar(String username, String contrasena, String rol);

    Usuarios login(String username, String contrasena);

    List<Usuarios> listar();

    void eliminar(Integer id);
}