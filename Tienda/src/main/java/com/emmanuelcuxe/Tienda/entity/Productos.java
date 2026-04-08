package com.emmanuelcuxe.Tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Productos")

public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Integer codigoProducto;

    @NotBlank(message = "Nombre del producto obligatorio")
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull(message = "Precio del producto obligatorio")
    @Column(name = "precio")
    private Double precio;

    @NotNull(message = "Stock del producto obligatorio")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "Estado del producto obligatorio")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}