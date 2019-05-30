package org.brujula.DAO;

import org.brujula.DAO.util.AlquilerDAO;
import org.brujula.DAO.util.JPAUtil;
import org.brujula.Model.Alquiler;
import org.brujula.Model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AlquilerDAOImpl implements AlquilerDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Alquiler buscar(Integer id) {
        return entity.find(Alquiler.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        Alquiler alquiler = buscar(id);
        entity.getTransaction().begin();
        entity.remove(alquiler);
        entity.getTransaction().commit();

    }

    @Override
    public void registrar(Alquiler type) {
        entity.getTransaction().begin();
        entity.persist(type);
        entity.getTransaction().commit();
    }

    @Override
    public void editar(Alquiler type) {
        entity.getTransaction().begin();
        entity.merge(type);
        entity.getTransaction().commit();
    }

    @Override
    public List<Alquiler> listaPeliculasAlquiladas(Usuario usuario) {
        entity.getTransaction().begin();
        Query query = entity.createQuery("select a from Alquiler a where a.idUsuario = ?1");
        query.setParameter(1,usuario);
        entity.getTransaction().commit();
        return query.getResultList();
    }
}
