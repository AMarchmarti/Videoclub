package org.brujula.DAO;

import org.brujula.DAO.util.GeneroDAO;
import org.brujula.DAO.util.JPAUtil;
import org.brujula.Model.Genero;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GeneroDAOImpl implements GeneroDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Genero> findAll() {
        entity.getTransaction().begin();
        Query query = entity.createQuery("select g.nombre from Genero g");
        entity.getTransaction().commit();
        JPAUtil.shutdown();
        return query.getResultList();
    }

    @Override
    public void registrar(Genero type) {
        entity.getTransaction().begin();
        entity.persist(type);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public void editar(Genero type) {
        entity.getTransaction().begin();
        entity.merge(type);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }
}
