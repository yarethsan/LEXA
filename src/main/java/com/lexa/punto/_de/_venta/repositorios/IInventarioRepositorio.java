package com.lexa.punto._de._venta.repositorios;

import com.lexa.punto._de._venta.modelos.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepositorio extends JpaRepository<Inventario,Integer> {
}
