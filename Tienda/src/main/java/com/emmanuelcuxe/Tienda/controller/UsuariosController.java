package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import com.emmanuelcuxe.Tienda.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Usuarios")

public class UsuariosController {
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuariosById(@PathVariable Integer id) {
        try {
            Usuarios searchedUsuarios = usuariosService.getUsuariosById(id);
            return new ResponseEntity<>(searchedUsuarios, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createUsuarios(@Valid @RequestBody Usuarios usuarios) {
        try {
            Usuarios createdUsuarios = usuariosService.saveUsuarios(usuarios);
            return new ResponseEntity<>(createdUsuarios, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuarios(@PathVariable Integer id, @Valid @RequestBody Usuarios usuarios) {
        try {
            Usuarios updatedUsuarios = usuariosService.updateUsuarios(id, usuarios);
            return new ResponseEntity<>(updatedUsuarios, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarios(@PathVariable Integer id) {
        try {
            usuariosService.deleteUsuarios(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}