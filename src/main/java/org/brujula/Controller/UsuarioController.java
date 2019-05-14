package org.brujula.Controller;

import org.brujula.DAO.util.Utilities;
import org.brujula.Model.Persona;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

/**
 * Created by amarch on 10/05/2019.
 */
@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

    private Utilities<Usuario> usuarioUtilities;
    private Usuario usuario;

    private Persona persona ;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
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
            usuarioUtilities.registrar(usuario);
        }catch (Exception e){}
    }
}
