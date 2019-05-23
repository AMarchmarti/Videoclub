package org.brujula.Controller;

import org.brujula.DAO.GeneroDAOImpl;
import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.util.GeneroDAO;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Genero;
import org.brujula.Model.Pelicula;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class PeliculaController implements Serializable {


    private PeliculaDAO peliculaDAO;

    private GeneroDAO generoDAO;

    private Pelicula pelicula;

    private Genero genero;

    private List<Genero> listarGenero;

    private List<Pelicula> listaPeliculas;

    @PostConstruct
    public void init(){
        peliculaDAO = new PeliculaDAOImpl();
        generoDAO = new GeneroDAOImpl();
        pelicula = new Pelicula();
        genero = new Genero();
        listarGenero = generoDAO.findAll();
        listaPeliculas = peliculaDAO.recuperarPeliculas();
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

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public void registrarPelicula() {
        try {
            pelicula.setGenero(genero);
            peliculaDAO.registrar(pelicula);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enhorabuena ", pelicula.getTitulo() + " se añadió a la lista"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }

    }

    public List<Pelicula> mostrarPeliculas(){
        if (getListaPeliculas().isEmpty()){
            return null;
        }
        return getListaPeliculas();

}}
