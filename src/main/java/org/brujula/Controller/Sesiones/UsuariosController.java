package org.brujula.Controller.Sesiones;

import org.apache.commons.codec.digest.DigestUtils;
import org.brujula.Controller.Exceptions.UsuarioNoDisponible;
import org.brujula.DAO.PersonaDAOImpl;
import org.brujula.DAO.PromocionDAOImpl;
import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.PersonaDAO;
import org.brujula.DAO.util.PromocionDAO;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.CodigoPromocional;
import org.brujula.Model.Persona;
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

    private Persona persona;

    private PromocionDAO promocionDAO;

    private CodigoPromocional codigo;

    private String contraseña;

    private List<String> listaNombreUsuarios;

    private Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    @PostConstruct
    public void init() {
        listaUsuarios = usuarioDAO.mostrarUsuarios();
        usuario = new Usuario();
        persona = new Persona();
        codigo = new CodigoPromocional();
        usuarioDAO = new UsuarioDAOImpl();
        promocionDAO = new PromocionDAOImpl();
        listaNombreUsuarios = usuarioDAO.nombreUsuarios();
    }

    /*---------------Getters & Setters--------------*/

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public CodigoPromocional getCodigo() {
        return codigo;
    }

    public void setCodigo(CodigoPromocional codigo) {
        this.codigo = codigo;
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


    public List<Usuario> getListaUsuarios() { return listaUsuarios; }

    public void setListaUsuarios(List<Usuario> listaUsuarios) { this.listaUsuarios = listaUsuarios; }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    /*----------------Visualización de Usuario y Persona--------------------------*/

    public String mostrarDNI(Usuario usuario) {return personaDAO.buscar(usuario.getIdUsuario().getDni()).getDni(); }

    public String mostrarNombrePersona(Usuario usuario) {return personaDAO.buscar(usuario.getIdUsuario().getDni()).getNombre();}

    public String mostrarApellido(Usuario usuario) {return personaDAO.buscar(usuario.getIdUsuario().getDni()).getApellidos();}

    public String mostrarEmailUsuario() {return usuarioDAO.buscar(user.getId()).getIdUsuario().getEmail();}

    public String mostrarTelefonoUsuario() { return usuarioDAO.buscar(user.getId()).getIdUsuario().getTelefono();}

    public Date mostrarFechaNacimientoUsuario() {return (Date) usuarioDAO.buscar(user.getId()).getIdUsuario().getFechaNacimiento();}

    public String mostrarDNI() { return personaDAO.buscar(user.getIdUsuario().getDni()).getDni(); }

    public String mostrarNombreCompletoPersona() {
        String nombre = this.mostrarNombrePersona(user);
        String apellido = this.mostrarApellido(user);
        return nombre + " " + apellido;
    }

    public String estadoUsuario(Usuario usuario) { return (usuario.getEstado()) ? "Conectado" : "Desconectado"; }

    /*----------------------Lógica para efectuar el reistro, edición y eliminación------------*/

    private Boolean esAdmin() {
        if (promocionDAO.codigoPromocional(codigo.getCodigo()) != null) {
            usuario.setTipo("A");
            return true;
        } else {
            usuario.setTipo("O");
            return false;
        }
    }

    private void modificado(){
        if (contraseña.equals("")){
            user.setClave(usuarioDAO.buscar(user.getId()).getClave());
        }else{
            user.setClave(DigestUtils.md5Hex(contraseña));
        }
        if (codigo.equals("")){
            user.setTipo(usuarioDAO.buscar(user.getId()).getTipo());
        }else{
            esAdmin();
        }
    }

    private void existeUsuario() throws UsuarioNoDisponible {
        if (listaUsuarios.contains(usuario.getUsuario())) {
            throw new UsuarioNoDisponible();
        }
    }


    public void registrar() {
        try {
            existeUsuario();
            this.usuario.setIdUsuario(persona);
            usuario.setClave(DigestUtils.md5Hex(contraseña));
            if (esAdmin()) {
                usuarioDAO.registrar(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Aviso", persona.getNombre() + " se registró como usuario admin"));
            } else {
                usuarioDAO.registrar(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Aviso", persona.getNombre() + " se registró"));
            }

        } catch (UsuarioNoDisponible e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Aviso", "Ese nombre de usuario ya esta cogido, por favor introduzca otro"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Aviso", "Error!"));
        }
    }

    public Boolean botonEliminarUsuario(Usuario usuario) {
        if (usuarioDAO.buscar(usuario.getId()).getTipo().equals("A")) {
            return false;
        }
        return true;
    }

    public void eliminarUsuario(Usuario usuario) {
        try {
            usuarioDAO.eliminar(usuario.getId());
//            personaDAO.eliminar(usuario.getIdUsuario().getDni());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El usuario ha sio eliminado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ese Usuario no existe!"));
        }
    }


    public void editar() {
        try {

            personaDAO.editar(user.getIdUsuario());
            existeUsuario();
            modificado();
            usuarioDAO.editar(user);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Enhorabuena", "Tú usuario ha sido modificado con éxito"));
        }catch (UsuarioNoDisponible e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Aviso", "Ese nombre de usuario ya esta cogido, por favor introduzca otro"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Aviso", "Error!"));
        }

    }
}
