package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Pelicula;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class PeliculaDAOImpl implements PeliculaDAO, Serializable {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Pelicula buscar(Integer id) {
        return entity.find(Pelicula.class, id);
    }

    @Override
    public List<Pelicula> recuperarPeliculas() {
        entity.getTransaction().begin();
        Query query = entity.createQuery("select p from Pelicula p");
        entity.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public void registrar(Pelicula type) {
        entity.getTransaction().begin();
        entity.persist(type);
        entity.getTransaction().commit();

    }

    @Override
    public void editar(Pelicula type) {
        entity.getTransaction().begin();
        entity.merge(type);
        entity.getTransaction().commit();

    }


}
