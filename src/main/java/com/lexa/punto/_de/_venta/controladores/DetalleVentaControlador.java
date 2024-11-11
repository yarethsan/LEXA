package com.lexa.punto._de._venta.controladores;

import com.lexa.punto._de._venta.modelos.DetalleVenta;
import com.lexa.punto._de._venta.servicios.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-venta")
@CrossOrigin("*")
public class DetalleVentaControlador {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @PostMapping("/nuevos")
    public ResponseEntity<List<DetalleVenta>> agregarDetallesVenta(@RequestBody List<DetalleVenta> detallesVenta) {
        List<DetalleVenta> nuevosDetalles = detalleVentaService.agregarDetallesVenta(detallesVenta);
        return ResponseEntity.ok(nuevosDetalles);
    }

    @GetMapping("/")
    public ResponseEntity<List<DetalleVenta>> obtenerTodosDetalles() {
        List<DetalleVenta> detalles = detalleVentaService.obtenerTodosDetalles();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{idDetalle}")
    public ResponseEntity<DetalleVenta> obtenerDetallePorId(@PathVariable Integer idDetalle) {
        DetalleVenta detalle = detalleVentaService.obtenerDetallePorId(idDetalle);
        return ResponseEntity.ok(detalle);
    }

    /*@DeleteMapping("/{idDetalle}")
    public ResponseEntity<Void> eliminarDetalleVenta(@PathVariable Integer idDetalle) {
        detalleVentaService.eliminarDetalleVenta(idDetalle);
        return ResponseEntity.noContent().build();
  */  }

