package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import com.emmanuelcuxe.Tienda.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplements implements LoginService {

    @Autowired
    private LoginRepository repo;

    @Override
    public Usuarios registrar (String username, String contrasena, String rol) {

        if (repo.findByUsername(username) != null) {
            return null;
        }

        Usuarios u = new Usuarios();
        u.setUsername(username);
        u.setContrasena(contrasena);
        u.setRol(rol);
        u.setEmail("default@default.com");
        u.setEstado(1);

        return repo.save(u);
    }

    @Override
    public Usuarios login(String username, String contrasena) {

        Usuarios u = repo.findByUsername(username);

        if (u != null && u.getContrasena().equals(contrasena)) {
            return u;
        }

        return null;
    }

    @Override
    public List<Usuarios> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
