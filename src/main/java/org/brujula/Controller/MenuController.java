package org.brujula.Controller;

import org.brujula.DAO.GeneroDAOImpl;
import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.util.GeneroDAO;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Genero;
import org.brujula.Model.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped //Despues hay que cambiar a SEssionScoped para guardar el tipo de usuario con el que trabajamos
public class MenuController implements Serializable {

    private GeneroDAO generoDAO;

    private PeliculaDAO peliculaDAO;

    private List<Genero> lista;

    private MenuModel model;

    @PostConstruct
    public void init(){
        generoDAO = new GeneroDAOImpl();
        peliculaDAO = new PeliculaDAOImpl();
        model = new DefaultMenuModel();
        //Si queremos submenus hay que agregarlos aqui

    }

    public void listarMenu(){
        try{
            lista = generoDAO.findAll();
        }catch (Exception e){}
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String redirigirAñadir(){
        return "/protegido/añadir?faces-redirect=true";
    }

    public String redirigirIndex(){
        return "./../index?faces-redirect=true";
    }
}
