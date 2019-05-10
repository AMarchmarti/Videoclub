package org.brujula.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by amarch on 10/05/2019.
 */

public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown(){
        if(factory != null){
            factory.close();
        }
    }
}
