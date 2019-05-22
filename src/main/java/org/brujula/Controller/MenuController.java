package org.brujula.Controller;

import org.brujula.DAO.GeneroDAOImpl;
import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.util.GeneroDAO;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Genero;
import org.brujula.Model.Usuario;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
        return "./../index.xhtml";
    }

    public String redirigirPrincipal(){
        return "/protegido/principal?faces-redirect=true";}


    public String mostrarUsuario(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getUsuario();

    }

    public Boolean establecerpermisos(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        if (us.getTipo().equals("A")){
            return false;
        }
        return true;


    }


}
