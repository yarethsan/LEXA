package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Venta;
import com.lexa.punto._de._venta.repositorios.IVentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepositorio ventaRepositorio;

    @Override
    public Venta agregarVenta(Venta venta) {
        if (venta != null) {
            return ventaRepositorio.save(venta);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Los datos de la venta son inválidos");
    }

    @Override
    public Venta obtenerVentaporId(Integer idVenta) {
        return ventaRepositorio.findById(idVenta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada"));
    }

    @Override
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepositorio.findAll();
    }

    @Override
    public void eliminarVenta(Integer idVenta) {
        if (ventaRepositorio.existsById(idVenta)) {
            ventaRepositorio.deleteById(idVenta);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada");
        }
    }
}
