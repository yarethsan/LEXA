package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Inventario;
import com.lexa.punto._de._venta.repositorios.IInventarioRepositorio;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements IInventarioService {

    @Autowired
    private IInventarioRepositorio iInventarioRepositorio;
    @Override
    public Inventario agregarProducto(Inventario inventario) {
        if(inventario != null){
            return iInventarioRepositorio.save(inventario);
        }
        throw new RuntimeException("Sin datos");
    }

    @Override
    public Inventario actualizarProducto(Integer idProducto, Inventario inventario) {
        Inventario in = iInventarioRepositorio.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("No se encontraron datos"));
        in.setCantidadDisponible(inventario.getCantidadDisponible());
        in.setNombreProducto(inventario.getNombreProducto());
        in.setPrecio(inventario.getPrecio());

        return iInventarioRepositorio.save(in);
    }

    @Override
    public List<Inventario> obtenerTodoInventario() {
        List <Inventario> productos = iInventarioRepositorio.findAll();
        if (productos.isEmpty() ){
            throw new RuntimeException("No hay datos");
        }
        return productos;
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
            iInventarioRepositorio.deleteById(idProducto);
    }

    @Override
    public Optional<Inventario> obtenerProductoPorId(Integer id) {
        Inventario in = iInventarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontraron datos"));
        return Optional.ofNullable(in);
    }
}
