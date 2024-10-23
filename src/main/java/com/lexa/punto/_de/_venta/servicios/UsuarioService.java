package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Usuario;
import com.lexa.punto._de._venta.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws ResponseStatusException {
//VALIDAR CAMPOS
        if (usuario != null){
            Usuario nombre = usuarioRepositorio.findByNombre(usuario.getNombre());
            if (nombre.getNombre().contains(usuario.getNombre())) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
            return usuarioRepositorio.save(usuario);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Los Datos No Existen");
    }
}
