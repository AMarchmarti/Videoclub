package org.brujula.DAO.util;

import org.brujula.Model.Genero;

import java.util.List;

public interface GeneroDAO extends BaseDAO<Genero> {

    List<Genero> findAll();
}
