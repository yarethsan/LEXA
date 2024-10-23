package com.lexa.punto._de._venta.modelos;

import com.lexa.punto._de._venta.util.Roles;
import jakarta.persistence.*;

import java.util.Set;


@Table
@Entity (name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
private Integer idUsuario;
private String nombre;
    @Column(name = "contraseña")
private String contrasena;

    @OneToMany(mappedBy ="idUsuario",  fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Venta> venta;

@OneToOne()
@JoinColumn(name = "rol", referencedColumnName = "id_rol")
private Rol rol;

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
}
