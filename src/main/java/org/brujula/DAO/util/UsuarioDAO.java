package org.brujula.DAO.util;

import org.brujula.Model.Usuario;

import java.util.List;

public interface UsuarioDAO extends BaseDAO<Usuario> {

    Usuario buscar(Integer id);

    Usuario iniciarSesion(Usuario usuario);

    List<Usuario> mostrarUsuarios();
}
