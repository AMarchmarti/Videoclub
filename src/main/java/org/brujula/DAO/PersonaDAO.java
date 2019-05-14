package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.Utilities;
import org.brujula.Model.Persona;

import javax.persistence.EntityManager;

/**
 * Created by amarch on 10/05/2019.
 */
public class PersonaDAO implements Utilities<Persona> {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    //guardar Persona
    public void registrar(Persona persona){
        entity.getTransaction().begin();
        entity.persist(persona);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    //editar Persona
    public void editar(Persona persona){
        entity.getTransaction().begin();
        entity.merge(persona);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    //Buscar Persona
    public Persona buscar(String id){
        Persona persona = new Persona();
        persona = entity.find(Persona.class, id);
        JPAUtil.shutdown();
        return persona;
    }
}
