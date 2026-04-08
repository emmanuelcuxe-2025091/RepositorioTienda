package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.Clientes;
import com.emmanuelcuxe.Tienda.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/Clientes")

public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clientesService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientesById (@PathVariable Integer id){
        try {
            Clientes SearchedClientes = clientesService.getClientesById(id);
            return new ResponseEntity<>(SearchedClientes,HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createClientes (@Valid @RequestBody Clientes clientes) {
        try {
            Clientes createdClientes = clientesService.saveClientes(clientes);
            return new ResponseEntity<>(createdClientes, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpleado (@PathVariable Integer id, @Valid @RequestBody Clientes clientes) {
        try {
            Clientes updateClientes = clientesService.updateClientes(id, clientes);
            return new ResponseEntity<>(updateClientes, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientes (@Valid @PathVariable Integer id) {
        try {
            clientesService.deleteClientes(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}