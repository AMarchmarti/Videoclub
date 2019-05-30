package org.brujula.DAO.util;

import org.brujula.Model.Usuario;

import java.net.Inet4Address;
import java.util.List;

public interface UsuarioDAO extends BaseDAO<Usuario> {

    Usuario buscar(Integer id);

    Usuario iniciarSesion(Usuario usuario);

    List<Usuario> mostrarUsuarios();

    void eliminar(Integer id);

    Usuario buscarPorUsuario(String nombreUsuario);

    List<String> nombreUsuarios();

}
