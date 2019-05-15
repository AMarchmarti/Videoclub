package org.brujula.Controller;

import org.brujula.Model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class PlantillaController implements Serializable {

    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();

            Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

            if(usuario == null){
                context.getExternalContext().redirect("permisos.xhtml");
            }
        }catch (Exception e){}
    }
}
