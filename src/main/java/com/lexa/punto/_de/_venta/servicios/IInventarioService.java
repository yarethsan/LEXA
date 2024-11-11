package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Inventario;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {

    Inventario agregarProducto(Inventario inventario);

    Inventario actualizarProducto(Integer idProducto, Inventario inventario);

    List<Inventario> obtenerTodoInventario();

    void eliminarProducto(Integer idProducto);

    Optional<Inventario> obtenerProductoPorId(Integer id);

    List<Inventario>buscarCodigo(String nombre, String codigo);
}
