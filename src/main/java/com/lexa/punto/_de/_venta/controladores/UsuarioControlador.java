package com.lexa.punto._de._venta.controladores;

import com.lexa.punto._de._venta.modelos.Usuario;
import com.lexa.punto._de._venta.servicios.IUsuarioService;
import com.lexa.punto._de._venta.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("")
    public ResponseEntity<Usuario> mandarUsuario(@RequestBody Usuario mandarUsuario) throws ResponseStatusException {
        //SE INICIALIZA OBJETO DE TIPO USUARIO CON VALOR NULO
        Usuario usu  = usuarioService.agregarUsuario(mandarUsuario);
        return ResponseEntity.ok(usu);
    }
}
