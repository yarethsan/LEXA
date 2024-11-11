package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.DetalleVenta;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface IDetalleVentaService {
 DetalleVenta agregarDetalleVenta(DetalleVenta detalleVenta) throws ResponseStatusException;
 List<DetalleVenta> agregarDetallesVenta(List<DetalleVenta> detallesVenta) throws ResponseStatusException; // Nuevo método
 List<DetalleVenta> obtenerTodosDetalles();
 DetalleVenta obtenerDetallePorId(Integer idDetalle) throws ResponseStatusException;
 void eliminarDetalleVenta(Integer idDetalle);
}
