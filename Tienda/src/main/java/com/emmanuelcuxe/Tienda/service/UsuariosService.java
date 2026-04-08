package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuariosById(Integer id);
    Usuarios saveUsuarios (Usuarios usuarios) throws RuntimeException;
    Usuarios updateUsuarios (Integer id, Usuarios usuarios);
    void deleteUsuarios (Integer id);
}