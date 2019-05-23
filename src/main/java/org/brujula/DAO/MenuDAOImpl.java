package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.MenuDAO;
import org.brujula.Model.Menu;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class MenuDAOImpl implements MenuDAO{

    private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Menu> menuAdmin(){
        System.out.println("Hola");
        return entity.createQuery("select m from Menu m where m.tipoUsuario = 'O' or m.tipoUsuario = 'A'").getResultList();
    }

    @Override
    public List<Menu> menuUsuario() {
        System.out.println("Hola");
        return entity.createQuery("select m from Menu m where m.tipoUsuario = 'O'").getResultList();
    }
}
