package org.brujula.DAO.util;

import org.brujula.Model.Pelicula;

import java.util.List;

public interface PeliculaDAO extends BaseDAO<Pelicula> {

    Pelicula buscar(Integer id);

    List<Pelicula> recuperarPeliculas();


}
