package org.brujula.Controller;

import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Persona;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

/**
 * Created by amarch on 10/05/2019.
 */
@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

    private UsuarioDAO usuarioDAO;

    private Usuario usuario;

    private Persona persona ;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
        usuarioDAO = new UsuarioDAOImpl();
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void registrar(){
        try{
            this.usuario.setIdUsuario(persona);
            usuarioDAO.registrar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", persona.getNombre() + " se registró"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}
