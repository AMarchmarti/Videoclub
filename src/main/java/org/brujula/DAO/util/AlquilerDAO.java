package org.brujula.DAO.util;

import org.brujula.Model.Alquiler;
import org.brujula.Model.Usuario;

import java.util.List;

public interface AlquilerDAO extends BaseDAO<Alquiler> {

    Alquiler buscar(Integer id);

    void eliminar(Alquiler alquiler);

    List<Alquiler> listaPeliculasAlquiladas(Usuario usuario);
}
