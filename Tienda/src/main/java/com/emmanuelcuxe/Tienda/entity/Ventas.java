package com.emmanuelcuxe.Tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Ventas")

public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @NotNull(message = "Fecha de la venta obligatorio")
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @NotNull(message = "Estado de la venta obligatorio")
    @Column(name = "estado")
    private Integer estado;

    @NotNull(message = "Total de la venta obligatorio")
    @Column(name = "total")
    private Double total;

    @NotNull(message = "DPI del cliente de la venta obligatorio")
    @Column(name = "clientes_dpi_cliente")
    private Integer clientesDpiCliente;

    @NotNull(message = "Codigo del usuario de la venta obligatorio")
    @Column(name = "usuarios_codigo_usuario")
    private Integer usuariosCodigoUsuario;

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getClientesDpiCliente() {
        return clientesDpiCliente;
    }

    public void setClientesDpiCliente(Integer clientesDpiCliente) {
        this.clientesDpiCliente = clientesDpiCliente;
    }

    public Integer getUsuariosCodigoUsuario() {
        return usuariosCodigoUsuario;
    }

    public void setUsuariosCodigoUsuario(Integer usuariosCodigoUsuario) {
        this.usuariosCodigoUsuario = usuariosCodigoUsuario;
    }
}