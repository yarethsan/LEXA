package com.lexa.punto._de._venta.repositorios;

import com.lexa.punto._de._venta.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    Usuario findByNombre(String nombre);

}
