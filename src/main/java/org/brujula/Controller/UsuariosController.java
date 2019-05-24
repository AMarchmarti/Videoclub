package org.brujula.Controller;

import org.brujula.DAO.PersonaDAOImpl;
import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.PersonaDAO;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuariosController implements Serializable {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private PersonaDAO personaDAO = new PersonaDAOImpl();

    private String confirmacionEliminar;

    private List<Usuario> listaUsuarios;

    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        listaUsuarios = usuarioDAO.mostrarUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    public String mostrarDNI(Usuario usuario){
        return personaDAO.buscar(usuario.getIdUsuario().getDni()).getDni();
    }

    public String mostrarNombrePersona(Usuario usuario){
        return personaDAO.buscar(usuario.getIdUsuario().getDni()).getNombre();
    }

    public String mostrarApellido(Usuario usuario){
        return personaDAO.buscar(usuario.getIdUsuario().getDni()).getApellidos();
    }

    public String estadoUsuario(Usuario usuario){
        return (usuario.getEstado() == (short) 1) ? "Conectado" : "Desconectado";
    }

    public Boolean botonEliminarUsuario(Usuario usuario){
        if (usuarioDAO.buscar(usuario.getId()).getTipo().equals("A")){
            return false;
        }
        return true;
    }

    public void eliminarUsuario(Usuario usuario){
        try {
            usuarioDAO.eliminar(usuario.getId());
//            personaDAO.eliminar(usuario.getIdUsuario().getDni());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","El usuario ha sio eliminado"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Ese Usuario no existe!"));
        }
    }

}
