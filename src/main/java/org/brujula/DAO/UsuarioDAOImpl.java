package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by amarch on 10/05/2019.
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    //guardar usuario
    @Override
    public void registrar(Usuario usuario){
        entity.getTransaction().begin();
        entity.persist(usuario);
        entity.getTransaction().commit();
    }

    //editar usuario
    @Override
    public void editar(Usuario usuario){
        entity.getTransaction().begin();
        entity.merge(usuario);
        entity.getTransaction().commit();
    }

    //Buscar usuario
    @Override
    public Usuario buscar(Integer id){
        Usuario user = new Usuario();
        user = entity.find(Usuario.class, id);
        return user;
    }

    @Override
    public Usuario iniciarSesion(Usuario us) {
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "FROM Usuario u where u.usuario = ?1 and u.clave = ?2";
            Query query = entity.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getClave());

            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch (Exception e){
            throw e;
        }finally {
            entity.close();
        }
        return usuario;
    }
}
