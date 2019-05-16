package org.brujula.Controller;

import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Genero;
import org.brujula.Model.Pelicula;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class PeliculaController implements Serializable {

    private PeliculaDAO peliculaDAO;

    private Pelicula pelicula;

    private Genero genero;

    @PostConstruct
    public void init(){
        peliculaDAO = new PeliculaDAOImpl();
        pelicula = new Pelicula();
        genero = new Genero();
    }

    public void registrarPelicula(){
        pelicula.setGenero(genero);
        peliculaDAO.registrar(pelicula);
    }
}
