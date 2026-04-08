package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.DetalleVenta;
import com.emmanuelcuxe.Tienda.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) throws RuntimeException {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta) throws RuntimeException {
        detalleVenta.setCodigoDetalleVenta(id);
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}