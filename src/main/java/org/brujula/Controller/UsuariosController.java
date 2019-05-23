package org.brujula.Controller;

import org.brujula.DAO.PersonaDAOImpl;
import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.PersonaDAO;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuariosController implements Serializable {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    private PersonaDAO personaDAO = new PersonaDAOImpl();

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
        System.out.println("DNI");
        return personaDAO.buscar(usuario.getIdUsuario().getDni()).getDni();
    }

    public String mostrarNombrePersona(Usuario usuario){
        System.out.println("Nombre");
        return personaDAO.buscar(usuario.getIdUsuario().getDni()).getNombre();
    }

    public String mostrarApellido(Usuario usuario){
        System.out.println("Apellidos");
        return personaDAO.buscar(usuario.getIdUsuario().getDni()).getApellidos();
    }

    public String estadoUsuario(Usuario usuario){
        return (usuario.getEstado() == 1) ? "Conectado" : "Desconectado";
    }
}
