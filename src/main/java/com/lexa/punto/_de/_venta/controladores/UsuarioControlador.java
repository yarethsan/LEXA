package com.lexa.punto._de._venta.controladores;

import com.lexa.punto._de._venta.modelos.Usuario;
import com.lexa.punto._de._venta.servicios.IUsuarioService;
import com.lexa.punto._de._venta.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<Usuario> mandarUsuario(@RequestBody Usuario mandarUsuario) throws ResponseStatusException {
        //SE INICIALIZA OBJETO DE TIPO USUARIO CON VALOR NULO
        Usuario usu  = usuarioService.agregarUsuario(mandarUsuario);
        return ResponseEntity.ok(usu);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable Integer id){
        Usuario usuario = usuarioService.obtenerUsuarioId(id);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping ("/")
    public ResponseEntity<List<Usuario>> obtenerTodosUsuarios(){
        List<Usuario> usuario = usuarioService.obtenerTodosUsuarios();
        return ResponseEntity.ok(usuario);
    }

@PutMapping
    public ResponseEntity<?> pausarUsuario(@PathVariable Integer id){
        usuarioService.pausarUsuario(id);
        return  ResponseEntity.ok("Usuario pausado");
}
   /* DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario (@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }*/
}
