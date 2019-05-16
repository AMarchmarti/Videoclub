package org.brujula.Controller;

import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;



import java.io.Serializable;

@ManagedBean
@ViewScoped
public class IndexController implements Serializable {

    private UsuarioDAO usuarioDAO;

    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuarioDAO = new UsuarioDAOImpl();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion(){
        String redireccion = null;
        Usuario us;
        try{
            us = usuarioDAO.iniciarSesion(usuario);

            if(null != us){
                //Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);

                //redireccion ="/protegido/principal"; //Navegación implicita,porque no veo la ruta en el nav
                redireccion ="/protegido/principal?faces-redirect=true";//Navegación explicita
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Datos Incorrectos!"));
            }


        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","ERROR EN DB!"));
        }
        return redireccion;
    }
}
