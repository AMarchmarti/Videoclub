package org.brujula.DAO.util;

public interface BaseDAO<T> {

    void registrar(T type);

    void editar(T type);
}
