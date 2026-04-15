package com.emmanuelcuxe.Tienda.repository;

import com.emmanuelcuxe.Tienda.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LoginRepository extends JpaRepository<Usuarios, Integer> {

    Usuarios findByUsername (String username);
}