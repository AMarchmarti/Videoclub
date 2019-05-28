package org.brujula.DAO.util;

import org.brujula.Model.CodigoPromocional;

import javax.persistence.NamedQuery;
import java.util.List;

public interface PromocionDAO{

    CodigoPromocional codigoPromocional(String codigo);

    List<CodigoPromocional> codigos();
}
