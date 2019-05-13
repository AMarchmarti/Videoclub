package org.brujula.Controller;

import org.brujula.Model.Persona;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by amarch on 10/05/2019.
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    private Usuario usuario;
    private Persona persona;

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
}
