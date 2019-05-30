package org.brujula.DAO;

import org.apache.commons.codec.digest.DigestUtils;
import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Usuario;

import javax.faces.context.FacesContext;
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
        Usuario user = entity.find(Usuario.class, id);
        return user;
    }

    @Override
    public Usuario buscarPorUsuario(String nombreUsuario){
        return entity.find(Usuario.class, nombreUsuario);
    }

    @Override
    public Usuario iniciarSesion(Usuario us) {
        Usuario user = null;
        String consulta;
        try {
            consulta = "FROM Usuario u where u.usuario = ?1 and u.clave = ?2";
            Query query = entity.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, DigestUtils.md5Hex(us.getClave()));

            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                user = lista.get(0);
                user.setEstado(true);
                this.editar(user);
            }
        }catch (Exception e){
            throw e;
        }finally {
            entity.close();
        }
        return user;
    }

    @Override
    public List<String> nombreUsuarios(){return entity.createQuery("select u.usuario from Usuario u").getResultList();}

    @Override
    public List<Usuario> mostrarUsuarios(){
        return entity.createQuery("select u from Usuario u").getResultList();
    }

    @Override
    public void eliminar(Integer id){
        Usuario usuario = this.buscar(id);
        entity.getTransaction().begin();
        entity.remove(usuario);
        entity.getTransaction().commit();
    }
}
