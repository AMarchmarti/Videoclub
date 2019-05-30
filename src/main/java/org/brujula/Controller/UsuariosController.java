package org.brujula.Controller;

import org.brujula.DAO.PersonaDAOImpl;
import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.PersonaDAO;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.CodigoPromocional;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuariosController implements Serializable {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private PersonaDAO personaDAO = new PersonaDAOImpl();

    private List<Usuario> listaUsuarios;

    private Usuario usuario;

    private Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    @PostConstruct
    public void init(){
        listaUsuarios = usuarioDAO.mostrarUsuarios();
        usuario = new Usuario();
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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
        return (usuario.getEstado()) ? "Conectado" : "Desconectado";
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

    public String mostrarNombreCompletoPersona(){
        String nombre = this.mostrarNombrePersona(user);
        String apellido = this.mostrarApellido(user);
        return nombre + " " + apellido;
    }

    public String mostrarEmailUsuario(){
        return usuarioDAO.buscar(user.getId()).getIdUsuario().getEmail();
    }

    public String mostrarTelefonoUsuario(){
        return usuarioDAO.buscar(user.getId()).getIdUsuario().getTelefono();
    }

    public Date mostrarFechaNacimientoUsuario(){
        return (Date) usuarioDAO.buscar(user.getId()).getIdUsuario().getFechaNacimiento();
    }

    public String mostrarDNI(){
        return personaDAO.buscar(user.getIdUsuario().getDni()).getDni();
    }


    public void editar(){
        personaDAO.editar(user.getIdUsuario());
        usuarioDAO.editar(user);
    }
}
