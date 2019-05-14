package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.Utilities;
import org.brujula.Model.Usuario;

import javax.persistence.EntityManager;

/**
 * Created by amarch on 10/05/2019.
 */
public class UsuarioDAO implements Utilities<Usuario> {
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
