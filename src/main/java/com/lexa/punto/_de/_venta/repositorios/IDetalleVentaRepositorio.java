package com.lexa.punto._de._venta.repositorios;

import com.lexa.punto._de._venta.modelos.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepositorio extends JpaRepository <Venta, Integer> {
}
