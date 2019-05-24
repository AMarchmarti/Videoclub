package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.PersonaDAO;
import org.brujula.Model.Persona;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by amarch on 10/05/2019.
 */
public class PersonaDAOImpl implements PersonaDAO {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    //guardar Persona
    @Override
    public void registrar(Persona persona) {
        entity.getTransaction().begin();
        entity.persist(persona);
        entity.getTransaction().commit();
    }

    //editar Persona
    @Override
    public void editar(Persona persona) {
        entity.getTransaction().begin();
        entity.merge(persona);
        entity.getTransaction().commit();
    }

    //Buscar Persona
    @Override
    public Persona buscar(String id) {
        return entity.find(Persona.class, id);

    }

    @Override
    public void eliminar(String id) {
        Persona persona = this.buscar(id);
        entity.getTransaction().begin();
        entity.remove(persona);
        entity.getTransaction().commit();
    }
}
