package org.brujula.DAO.util;

import org.brujula.Model.Menu;

import java.util.List;

public interface MenuDAO {


    List<Menu> menuUsuario();

    List<Menu> menuAdmin();
}
