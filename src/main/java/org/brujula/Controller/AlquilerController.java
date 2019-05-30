package org.brujula.Controller;


import org.brujula.DAO.AlquilerDAOImpl;
import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.util.AlquilerDAO;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.Model.Alquiler;
import org.brujula.Model.Pelicula;
import org.brujula.Model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@ManagedBean
@ViewScoped
public class AlquilerController implements Serializable {


    private AlquilerDAO alquilerDAO;

    private Alquiler alquiler;

    private PeliculaDAO peliculaDAO;

    private List<Alquiler> misPeliculas;


    private Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    @PostConstruct
    public void init(){
        alquilerDAO = new AlquilerDAOImpl();
        peliculaDAO = new PeliculaDAOImpl();
        alquiler = new Alquiler();
        misPeliculas = alquilerDAO.listaPeliculasAlquiladas(usuario);
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Boolean estaAlquilada(Pelicula pelicula){
        if (!pelicula.getEstado()){
            return true;
        }
        return false;
    }

    public List<Alquiler> getMisPeliculas() {
        return misPeliculas;
    }

    public void setMisPeliculas(List<Alquiler> misPeliculas) {
        this.misPeliculas = misPeliculas;
    }


    public void alquilarPelicula(Pelicula pelicula){

        try{

            alquiler.setIdPelicula(pelicula);
            alquiler.setIdUsuario(usuario);
            alquiler.setFechaAlquiler(Date.valueOf(LocalDate.now()));
            alquilerDAO.registrar(alquiler);
            pelicula.setEstado(false);
            peliculaDAO.editar(pelicula);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Buena elección", "has alquilado " + pelicula.getTitulo()));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }

    }

    public void devolverPelicula(Alquiler peliculaAlquilada){
        peliculaAlquilada.getIdPelicula().setEstado(true);
        peliculaDAO.editar(peliculaAlquilada.getIdPelicula());
        alquilerDAO.eliminar(peliculaAlquilada.getIdAlquiler());

    }

    public List<Alquiler> mostrarPeliculasUsuario(Usuario user){
        return (usuario == user) ? misPeliculas : alquilerDAO.listaPeliculasAlquiladas(user);
    }
}
