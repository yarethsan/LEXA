package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Usuario;
import com.lexa.punto._de._venta.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService implements IUsuarioService {

    final static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;
    @Override
    public Usuario agregarUsuario(Usuario usuario) {
//SE COMIENZAN A VALIDAR LOS CAMPOS
        if (usuario != null){
            boolean validation = this.verificarNombre(usuario.getNombre());
            if (validation) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
            return usuarioRepositorio.save(usuario);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Los Datos No Existen");
    }
    
    private boolean verificarNombre(String nuevo){
        Usuario name = usuarioRepositorio.findByNombre(nuevo);
        return name != null;
        //si regresa un valor no vacio es un true, si regresa un vacio en false
    }
}
