package org.brujula.Controller;


import org.brujula.DAO.MenuDAOImpl;
import org.brujula.DAO.util.MenuDAO;

import org.brujula.Model.Menu;
import org.brujula.Model.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;



@ManagedBean
@SessionScoped //Despues hay que cambiar a SEssionScoped para guardar el tipo de usuario con el que trabajamos
public class MenuController implements Serializable {


    private MenuDAO menuDAO = new MenuDAOImpl();

    private MenuModel model;

    @PostConstruct
    public void init(){
        model = new DefaultMenuModel();
        this.visualizarMenu();
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

    public String redirigirPrincipal(){
        return "/protegido/principal?faces-redirect=true";}


    public String mostrarUsuario(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getUsuario();

    }

    public String redirigirUsuario(){
        return "/protegido/administrador/usuarios?faces-redirect=true";}


    public void visualizarMenu(){

        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        System.out.println(menuDAO.menuAdmin());
        System.out.println("------------------------------------");
        System.out.println(menuDAO.menuUsuario());
        if(us.getTipo().equals("A")){
            for (Menu menu : menuDAO.menuAdmin()) {
                DefaultMenuItem item = new DefaultMenuItem(menu.getNombre());

                model.addElement(item);}

        }else
            for (Menu menu : menuDAO.menuUsuario()){
                DefaultMenuItem item = new DefaultMenuItem(menu.getNombre());

                model.addElement(item);}
            }

    }


