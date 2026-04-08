package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.DetalleVenta;
import com.emmanuelcuxe.Tienda.service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/DetalleVenta")

public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaService.getAllDetalleVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalleVentaById(@PathVariable Integer id) {
        try {
            DetalleVenta searchedDetalleVenta = detalleVentaService.getDetalleVentaById(id);
            return new ResponseEntity<>(searchedDetalleVenta, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta createdDetalleVenta = detalleVentaService.saveDetalleVenta(detalleVenta);
            return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetalleVenta(@PathVariable Integer id, @Valid @RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta updatedDetalleVenta = detalleVentaService.updateDetalleVenta(id, detalleVenta);
            return new ResponseEntity<>(updatedDetalleVenta, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetalleVenta(@PathVariable Integer id) {
        try {
            detalleVentaService.deleteDetalleVenta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}