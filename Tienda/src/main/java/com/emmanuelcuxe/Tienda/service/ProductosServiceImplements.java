package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Productos;
import com.emmanuelcuxe.Tienda.repository.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImplements implements ProductosService {
    private final ProductosRepository productosRepository;

    public ProductosServiceImplements(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductosById(Integer id) {
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    public Productos saveProductos(Productos productos) throws RuntimeException {
        return productosRepository.save(productos);
    }

    @Override
    public Productos updateProductos(Integer id, Productos productos) throws RuntimeException {
        productos.setCodigoProducto(id);
        return productosRepository.save(productos);
    }

    @Override
    public void deleteProductos(Integer id) {
        productosRepository.deleteById(id);
    }
}