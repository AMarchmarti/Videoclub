package org.brujula.DAO.util;

import org.brujula.Model.Alquiler;

public interface AlquilerDAO extends BaseDAO<Alquiler> {

    Alquiler buscar(Integer id);

    void eliminar(Alquiler alquiler);
}
