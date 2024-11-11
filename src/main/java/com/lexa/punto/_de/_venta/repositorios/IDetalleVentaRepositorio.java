package com.lexa.punto._de._venta.repositorios;

import com.lexa.punto._de._venta.modelos.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVentaRepositorio extends JpaRepository<DetalleVenta, Integer> {
    List<DetalleVenta> findByVenta_idVenta(Integer idVenta);
}
