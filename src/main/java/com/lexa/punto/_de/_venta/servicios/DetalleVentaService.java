package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.DetalleVenta;
import com.lexa.punto._de._venta.repositorios.IDetalleVentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService implements IDetalleVentaService {
    @Autowired
    private IDetalleVentaRepositorio detalleVentaRepositorio;

    @Override
    public DetalleVenta agregarDetalleVenta(DetalleVenta detalleVenta) {
        if (detalleVenta != null) {
            return detalleVentaRepositorio.save(detalleVenta);
        }
        throw new RuntimeException("Detalle de venta no puede ser nulo");
    }

    @Override
    public List<DetalleVenta> agregarDetallesVenta(List<DetalleVenta> detallesVenta) {
        if (detallesVenta != null && !detallesVenta.isEmpty()) {
            return detalleVentaRepositorio.saveAll(detallesVenta);
        }
        throw new RuntimeException("La lista de detalles de venta no puede estar vacía");
    }

    @Override
    public List<DetalleVenta> obtenerTodosDetalles() {
        return detalleVentaRepositorio.findAll();
    }

    @Override
    public DetalleVenta obtenerDetallePorId(Integer idDetalle) {
        return detalleVentaRepositorio.findById(idDetalle)
                .orElseThrow(() -> new RuntimeException("No se encontró el detalle de venta con ID: " + idDetalle));
    }

    @Override
    public void eliminarDetalleVenta(Integer idDetalle) {
        detalleVentaRepositorio.deleteById(idDetalle);
    }
}
