package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Ventas;
import com.emmanuelcuxe.Tienda.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService {
    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) throws RuntimeException {
        ventas.setCodigoVenta(id);
        return ventasRepository.save(ventas);
    }

    @Override
    public void deleteVentas(Integer id) {
        ventasRepository.deleteById(id);
    }
}