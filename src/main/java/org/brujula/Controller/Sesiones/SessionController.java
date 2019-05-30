package org.brujula.Controller.Sesiones;

import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class SessionController implements Serializable {

    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAOImpl();
    }

    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();

            Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            if(usuario == null){
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        }catch (Exception e){}
    }

    public void cerrarSesion(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        us.setEstado(false);
        usuarioDAO.editar(us);

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public Boolean establecerpermisos(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        if (us.getTipo().equals("A")){
            return true;
        }
        return false;


    }
}
