package org.brujula.DAO;

import org.brujula.DAO.util.AlquilerDAO;
import org.brujula.DAO.util.JPAUtil;
import org.brujula.Model.Alquiler;

import javax.persistence.EntityManager;

public class AlquilerDAOImpl implements AlquilerDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Alquiler buscar(Integer id) {
        return entity.find(Alquiler.class, id);
    }

    @Override
    public void eliminar(Alquiler alquiler) {

    }

    @Override
    public void registrar(Alquiler type) {
        entity.getTransaction().begin();
        entity.persist(type);
        entity.getTransaction().commit();
    }

    @Override
    public void editar(Alquiler type) {

    }
}
