package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.DetalleVenta;
import com.lexa.punto._de._venta.modelos.Inventario;
import com.lexa.punto._de._venta.modelos.Venta;
import com.lexa.punto._de._venta.repositorios.IDetalleVentaRepositorio;
import com.lexa.punto._de._venta.repositorios.IInventarioRepositorio;
import com.lexa.punto._de._venta.repositorios.IVentaRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService implements IDetalleVentaService {

    final static Logger logger = LoggerFactory.getLogger(DetalleVentaService.class);
    @Autowired
    private IDetalleVentaRepositorio detalleVentaRepositorio;

    @Autowired
    private IVentaRepositorio ventaRepositorio;

    @Autowired
    private IInventarioRepositorio inventarioRepositorio;

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
            logger.info("Detalle {}", detallesVenta);
            for (DetalleVenta detalle : detallesVenta) {
                // Buscar la entidad Venta usando el ID
                Venta venta = ventaRepositorio.findById(detalle.getVenta().getIdVenta())
                        .orElseThrow(() -> new RuntimeException("La venta con ID " + detalle.getVenta().getIdVenta() + " no existe"));

                // Buscar la entidad Inventario usando el ID
                Inventario inventario = inventarioRepositorio.findById(detalle.getInventario().getIdProducto())
                        .orElseThrow(() -> new RuntimeException("El producto con ID " + detalle.getInventario().getIdProducto() + " no existe"));

                // Asignar las entidades recuperadas a DetalleVenta
                detalle.setVenta(venta);
                detalle.setProducto(inventario);
            }

            // Guardar todos los Detalles de Venta después de haber asignado correctamente las relaciones
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
