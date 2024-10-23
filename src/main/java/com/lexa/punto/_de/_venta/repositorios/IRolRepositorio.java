package com.lexa.punto._de._venta.repositorios;

import com.lexa.punto._de._venta.modelos.Rol;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepositorio extends JpaRepository <Rol, Integer> {
}
