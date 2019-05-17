package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.PersonaDAO;
import org.brujula.Model.Persona;

import javax.persistence.EntityManager;

/**
 * Created by amarch on 10/05/2019.
 */
public class PersonaDAOImpl implements PersonaDAO {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    //guardar Persona
    @Override
    public void registrar(Persona persona){
        entity.getTransaction().begin();
        entity.persist(persona);
        entity.getTransaction().commit();
    }

    //editar Persona
    @Override
    public void editar(Persona persona){
        entity.getTransaction().begin();
        entity.merge(persona);
        entity.getTransaction().commit();
    }

    //Buscar Persona
    @Override
    public Persona buscar(String id){
        Persona persona = new Persona();
        persona = entity.find(Persona.class, id);
        return persona;
    }
}
