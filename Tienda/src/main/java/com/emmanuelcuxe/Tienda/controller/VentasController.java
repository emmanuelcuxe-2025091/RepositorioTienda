package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.Ventas;
import com.emmanuelcuxe.Tienda.service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Ventas")

public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas() {
        return ventasService.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentasById(@PathVariable Integer id) {
        try {
            Ventas searchedVentas = ventasService.getVentasById(id);
            return new ResponseEntity<>(searchedVentas, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Ventas ventas) {
        try {
            Ventas createdVentas = ventasService.saveVentas(ventas);
            return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVentas(@PathVariable Integer id, @Valid @RequestBody Ventas ventas) {
        try {
            Ventas updatedVentas = ventasService.updateVentas(id, ventas);
            return new ResponseEntity<>(updatedVentas, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVentas(@PathVariable Integer id) {
        try {
            ventasService.deleteVentas(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}