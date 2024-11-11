package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Usuario;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface IUsuarioService {


    //METODOS ABSTRACTOS
    Usuario agregarUsuario(Usuario usuario) throws ResponseStatusException;

    //METODOS AGREGADO DE EXPERIMENTO
    Usuario obtenerUsuarioId(Integer id) throws ResponseStatusException;
    List<Usuario> obtenerTodosUsuarios();
    void  pausarUsuario(Integer idUsuario);
    // void eliminarUsuario (Integer idUsuario);
}
