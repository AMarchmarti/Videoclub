package org.brujula.Controller.Sesiones;

import org.brujula.Model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class SessionController implements Serializable {

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
        us.setEstado(Short.valueOf((short)0));
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
