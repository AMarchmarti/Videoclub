package org.brujula.DAO;

import org.brujula.DAO.util.JPAUtil;
import org.brujula.DAO.util.PromocionDAO;
import org.brujula.Model.CodigoPromocional;

import javax.persistence.EntityManager;
import java.util.List;

public class PromocionDAOImpl implements PromocionDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public CodigoPromocional codigoPromocional(String codigo) {
        return entity.find(CodigoPromocional.class, codigo);
    }

    @Override
    public List<CodigoPromocional> codigos() {
        return entity.createQuery("select cp from CodigoPromocional cp").getResultList();
    }
}
