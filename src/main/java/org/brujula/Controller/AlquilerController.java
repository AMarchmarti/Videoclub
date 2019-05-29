package org.brujula.Controller;

import org.brujula.Controller.Exceptions.PeliculaAlqulada;
import org.brujula.DAO.AlquilerDAOImpl;
import org.brujula.DAO.PeliculaDAOImpl;
import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.AlquilerDAO;
import org.brujula.DAO.util.PeliculaDAO;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Alquiler;
import org.brujula.Model.Pelicula;
import org.brujula.Model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


@ManagedBean
@SessionScoped
public class AlquilerController implements Serializable {


    private AlquilerDAO alquilerDAO;

    private Alquiler alquiler;

    private PeliculaDAO peliculaDAO;

    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init(){
        alquilerDAO = new AlquilerDAOImpl();
        peliculaDAO = new PeliculaDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
        alquiler = new Alquiler();
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



    public void alquilarPelicula(Pelicula pelicula){
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
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
}
