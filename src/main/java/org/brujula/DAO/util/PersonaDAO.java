package org.brujula.DAO.util;

import org.brujula.Model.Persona;

public interface PersonaDAO extends BaseDAO<Persona>{

    Persona buscar(String id);
}
