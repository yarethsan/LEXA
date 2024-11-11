package com.lexa.punto._de._venta.repositorios;

import com.lexa.punto._de._venta.modelos.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInventarioRepositorio extends JpaRepository<Inventario,Integer> {
    List<Inventario> findByNombreProductoContainingOrCodigo(String nombre, String codigo);

}
