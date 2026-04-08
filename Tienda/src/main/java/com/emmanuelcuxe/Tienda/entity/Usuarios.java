package com.emmanuelcuxe.Tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")

public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotBlank(message = "Nombre del usuario obligatorio")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Contraseña del usuario obligatorio")
    @Column(name = "contrasena")
    private String contrasena;

    @NotBlank(message = "Email del usuario obligatorio")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Rol del usuario obligatorio")
    @Column(name = "rol")
    private String rol;

    @NotNull(message = "Estado del usuario obligatorio")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}