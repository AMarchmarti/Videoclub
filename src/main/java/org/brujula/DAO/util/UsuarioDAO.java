package org.brujula.DAO.util;

import org.brujula.Model.Usuario;

public interface UsuarioDAO extends BaseDAO<Usuario> {

    Usuario buscar(Integer id);
}
