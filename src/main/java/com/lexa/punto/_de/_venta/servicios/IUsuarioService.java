package com.lexa.punto._de._venta.servicios;

import com.lexa.punto._de._venta.modelos.Usuario;
import org.springframework.web.server.ResponseStatusException;

public interface IUsuarioService {


    //METODOS ABSTRACTOS
    Usuario agregarUsuario(Usuario usuario) throws ResponseStatusException;
}
