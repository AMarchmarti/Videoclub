package org.brujula.DAO;

import org.brujula.Model.Usuario;

import javax.naming.LimitExceededException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarch on 10/05/2019.
 */
public class UsuarioDAO {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    //guardar usuario
    public void registrar(Usuario usuario){
        entity.getTransaction().begin();
        entity.persist(usuario);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    //editar usuario
    public void editar(Usuario usuario){
        entity.getTransaction().begin();
        entity.merge(usuario);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    //Buscar usuario
    public Usuario buscar(Integer id){
        Usuario user = new Usuario();
        user = entity.find(Usuario.class, id);
        JPAUtil.shutdown();
        return user;
    }

}
