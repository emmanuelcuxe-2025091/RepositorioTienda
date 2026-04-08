package com.emmanuelcuxe.Tienda.controller;

import com.emmanuelcuxe.Tienda.entity.Productos;
import com.emmanuelcuxe.Tienda.service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Productos")

public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> getAllProductos() {
        return productosService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductosById(@PathVariable Integer id) {
        try {
            Productos searchedProductos = productosService.getProductosById(id);
            return new ResponseEntity<>(searchedProductos, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createProductos(@Valid @RequestBody Productos productos) {
        try {
            Productos createdProductos = productosService.saveProductos(productos);
            return new ResponseEntity<>(createdProductos, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductos(@PathVariable Integer id, @Valid @RequestBody Productos productos) {
        try {
            Productos updatedProductos = productosService.updateProductos(id, productos);
            return new ResponseEntity<>(updatedProductos, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductos(@PathVariable Integer id) {
        try {
            productosService.deleteProductos(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}