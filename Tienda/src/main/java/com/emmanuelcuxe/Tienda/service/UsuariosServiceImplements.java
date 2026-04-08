package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import com.emmanuelcuxe.Tienda.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuariosService {
    private final UsuariosRepository usuariosRepository;

    public UsuariosServiceImplements(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUsuariosById(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios saveUsuarios(Usuarios usuarios) throws RuntimeException {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios updateUsuarios(Integer id, Usuarios usuarios) throws RuntimeException{
        usuarios.setCodigoUsuario(id);
        return usuariosRepository.save(usuarios);
    }

    @Override
    public void deleteUsuarios(Integer id) {
        usuariosRepository.deleteById(id);
    }
}