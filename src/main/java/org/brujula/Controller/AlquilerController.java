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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class AlquilerController implements Serializable {


    private AlquilerDAO alquilerDAO;

    private Alquiler alquiler;

    private PeliculaDAO peliculaDAO;

    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init(){
        alquilerDAO = new AlquilerDAOImpl();
        alquiler = new Alquiler();
        peliculaDAO = new PeliculaDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void estaAlquilada(Pelicula pelicula) throws PeliculaAlqulada{
        if (!pelicula.getEstado()){
            throw new PeliculaAlqulada();
        }
    }

    public void alquilarPelicula(Pelicula pelicula){
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        try{
            estaAlquilada(pelicula);
            alquiler.setIdPelicula(pelicula);
            alquiler.setIdUsuario(usuarioDAO.buscar(usuario.getId()));
            alquilerDAO.registrar(alquiler);
            pelicula.setEstado(false);
            peliculaDAO.editar(pelicula);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Buena elección", "has alquilado " + pelicula.getTitulo()));
        }catch (PeliculaAlqulada e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Lo sentimos", "esta pelicula está alquilada"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }

    }
}
