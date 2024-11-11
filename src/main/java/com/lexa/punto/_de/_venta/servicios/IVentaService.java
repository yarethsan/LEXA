package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Venta;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface IVentaService {

    Venta agregarVenta(Venta venta) throws ResponseStatusException;

    Venta obtenerVentaporId(Integer idVenta) throws ResponseStatusException;

    List<Venta> obtenerTodasLasVentas();

    void eliminarVenta(Integer idVenta);
}
