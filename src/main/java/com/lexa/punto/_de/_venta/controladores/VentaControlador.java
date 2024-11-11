package com.lexa.punto._de._venta.controladores;

import com.lexa.punto._de._venta.modelos.Venta;
import com.lexa.punto._de._venta.servicios.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin("*")
public class VentaControlador {

    @Autowired
    private IVentaService ventaService;

    // nueva venta
    @PostMapping("/nueva")
    public ResponseEntity<Venta> agregarVenta(@RequestBody Venta mandarVenta) throws ResponseStatusException {
        Venta nuevaVenta = ventaService.agregarVenta(mandarVenta);
        return ResponseEntity.ok(nuevaVenta);
    }


    //  todas las ventas
    @GetMapping("/")
    public ResponseEntity<List<Venta>> obtenerTodasLasVentas() {
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();
        return ResponseEntity.ok(ventas);
    }

    // venta por ID
    @GetMapping("/{idVenta}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Integer idVenta) {
        Venta venta = ventaService.obtenerVentaporId(idVenta);
        return ResponseEntity.ok(venta);
    }

    //  eliminar una venta por ID
    @PutMapping ("/{idVenta}")
    public ResponseEntity<?> pausarVenta(@PathVariable Integer idVenta) {
        ventaService.eliminarVenta(idVenta);
        return ResponseEntity.noContent().build();
    }
}
