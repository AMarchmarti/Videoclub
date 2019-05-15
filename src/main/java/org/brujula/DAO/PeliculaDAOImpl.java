package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Pelicula;

import javax.persistence.EntityManager;
import java.util.List;

public class PeliculaDAOImpl implements PeliculaDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Pelicula buscar(Integer id) {
        return null;
    }

    @Override
    public List<Pelicula> findAll() {
        return null;
    }

    @Override
    public void registrar(Pelicula type) {
        entity.getTransaction().begin();
        entity.persist(type);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public void editar(Pelicula type) {
        entity.getTransaction().begin();
        entity.merge(type);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }
}
