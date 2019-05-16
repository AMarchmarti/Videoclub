package org.brujula.Controller;

import org.brujula.DAO.GeneroDAOImpl;
import org.brujula.DAO.util.GeneroDAO;
import org.brujula.Model.Genero;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class GeneroController implements Serializable {

    private GeneroDAO generoDAO;

    private List<Genero> listarGenero;

    private Genero genero;

    @PostConstruct
    public void init(){
        genero = new Genero();
        generoDAO = new GeneroDAOImpl();
        listarGenero = generoDAO.findAll();
    }

    public List<Genero> getListarGenero() {
        return listarGenero;
    }

    public void setListarGenero(List<Genero> listarGenero) {
        this.listarGenero = listarGenero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void añadirCategoria(){
        try{
            generoDAO.registrar(genero);
        }catch (Exception e){}
    }

}
