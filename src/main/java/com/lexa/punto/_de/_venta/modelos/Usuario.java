package com.lexa.punto._de._venta.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lexa.punto._de._venta.util.Roles;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.Set;


@Table
@Entity (name = "usuarios")
@ToString
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
private Integer idUsuario;
private String nombre;
    @Column(name = "contrasena")
private String contrasena;

    @OneToMany(mappedBy ="idUsuario",  fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Venta> venta;


@OneToOne()
@JoinColumn(name = "rol", referencedColumnName = "id_rol")
private Rol rol;
private boolean activo = true;
    //GET Y SET

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Set<Venta> venta) {
        this.venta = venta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
