package org.brujula.Controller;

import org.brujula.DAO.GeneroDAOImpl;
import org.brujula.DAO.ImagenTemporal;
import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.util.GeneroDAO;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Genero;
import org.brujula.Model.Pelicula;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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

    private String imagenPelicula;

    private List<Genero> listarGenero;

    @PostConstruct
    public void init(){
        peliculaDAO = new PeliculaDAOImpl();
        generoDAO = new GeneroDAOImpl();
        pelicula = new Pelicula();
        genero = new Genero();
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

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getImagenPelicula() {
        return imagenPelicula;
    }

    public void setImagenPelicula(String imagenPelicula) {
        this.imagenPelicula = imagenPelicula;
    }

    public void subirImagen(FileUploadEvent event) {
        try {
            pelicula.setImagen(event.getFile().getContents());
            imagenPelicula = ImagenTemporal.guardarBlobEnFicheroTemporal(pelicula.getImagen(), event.getFile().getFileName());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Imagen subida","Imagen añadida"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
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

}
