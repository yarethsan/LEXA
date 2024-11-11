package com.lexa.punto._de._venta.controladores;

import com.lexa.punto._de._venta.modelos.Inventario;
import com.lexa.punto._de._venta.servicios.IInventarioService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
@CrossOrigin("*")
public class InventarioControlador {

    @Autowired
    private IInventarioService inventarioService;
    //GET
   @GetMapping("/")
   public ResponseEntity<List<Inventario >> mostrarInventario (){
       List<Inventario> l =inventarioService.obtenerTodoInventario();
       return ResponseEntity.ok(l);
   }

    @PostMapping("/nuevo")
    public ResponseEntity<Inventario> nuevoInventario(@RequestBody Inventario inventario) {
        Inventario producto = inventarioService.agregarProducto(inventario);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/edita/{idInventario}")
    public ResponseEntity<Inventario> actualizarInventario(@RequestBody Inventario inventario , @PathVariable Integer idInventario){
    Inventario producto = inventarioService.actualizarProducto(idInventario, inventario);
       return ResponseEntity.ok(producto);
    }
@DeleteMapping("/{idInventario}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer idInventario){
    inventarioService.eliminarProducto(idInventario);
       return ResponseEntity.ok(HttpStatus.OK);
}
@GetMapping("/{idInventario}")
    public ResponseEntity<Inventario> mostrarInventarioid(@PathVariable Integer idInventario){
       Optional<Inventario> list=inventarioService.obtenerProductoPorId(idInventario);
       return ResponseEntity.ok(list.get());
}
@GetMapping("/buscar")
    public ResponseEntity<List<Inventario>> busquedaCodigo(@RequestParam String nombre, @RequestParam String codigo){

       List<Inventario> list=inventarioService.buscarCodigo(nombre, codigo);
       return ResponseEntity.ok(list);
}
}
