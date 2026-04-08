package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> getAllDetalleVenta();
    DetalleVenta getDetalleVentaById(Integer id);
    DetalleVenta saveDetalleVenta (DetalleVenta detalleVenta) throws RuntimeException;
    DetalleVenta updateDetalleVenta (Integer id, DetalleVenta detalleVenta);
    void deleteDetalleVenta (Integer id);
}