package com.emmanuelcuxe.Tienda.repository;

import com.emmanuelcuxe.Tienda.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}