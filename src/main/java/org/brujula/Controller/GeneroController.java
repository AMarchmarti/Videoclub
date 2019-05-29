package org.brujula.Controller;

import org.brujula.DAO.GeneroDAOImpl;
import org.brujula.DAO.util.GeneroDAO;
import org.brujula.Model.Genero;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "generoController")
@ViewScoped
public class GeneroController implements Serializable {

    private GeneroDAO generoDAO;

    private List<Genero> listarGenero;

    @ManagedProperty(value = "#{generoModel}")
    private Genero genero;

    @PostConstruct
    public void init() {
        generoDAO = new GeneroDAOImpl();
        setListarGenero();

    }

    public List<Genero> getListarGenero() {
        return listarGenero;
    }

    public void setListarGenero() {
        this.listarGenero = generoDAO.findAll();
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void añadirCategoria() {
        try {
            if (!getListarGenero().contains(genero.getNombre())) {
                generoDAO.registrar(genero);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Ese genero ya esta en la lista!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }


}
