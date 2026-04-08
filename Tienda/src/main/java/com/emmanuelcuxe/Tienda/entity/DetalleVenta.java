package com.emmanuelcuxe.Tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_venta")

public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigoDetalleVenta;

    @NotNull(message = "Cantidad de la venta obligatorio")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "Precio unitario de la venta obligatorio")
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull(message = "Subtotal de la venta obligatorio")
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull(message = "Codigo del producto de la venta obligatorio")
    @Column(name = "productos_codigo_producto")
    private Integer productosCodigoProducto;

    @NotNull(message = "Codigo de la venta obligatorio")
    @Column(name = "ventas_codigo_venta")
    private Integer ventasCodigoVenta;

    public Integer getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductosCodigoProducto() {
        return productosCodigoProducto;
    }

    public void setProductosCodigoProducto(Integer productosCodigoProducto) {
        this.productosCodigoProducto = productosCodigoProducto;
    }

    public Integer getVentasCodigoVenta() {
        return ventasCodigoVenta;
    }

    public void setVentasCodigoVenta(Integer ventasCodigoVenta) {
        this.ventasCodigoVenta = ventasCodigoVenta;
    }
}