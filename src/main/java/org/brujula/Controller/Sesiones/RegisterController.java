package org.brujula.Controller.Sesiones;

import org.apache.commons.codec.digest.DigestUtils;
import org.brujula.Controller.Exceptions.UsuarioNoDisponible;
import org.brujula.DAO.PromocionDAOImpl;
import org.brujula.DAO.UsuarioDAOImpl;
import org.brujula.DAO.util.PromocionDAO;
import org.brujula.DAO.util.UsuarioDAO;
import org.brujula.Model.CodigoPromocional;
import org.brujula.Model.Persona;
import org.brujula.Model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by amarch on 10/05/2019.
 */
@ManagedBean
@ViewScoped
public class RegisterController implements Serializable {

    private UsuarioDAO usuarioDAO;

    private PromocionDAO promocionDAO;

    private CodigoPromocional codigo;

    private String contraseña;

    private Usuario usuario;

    private Persona persona ;

    private List<String> listaUsuarios;

    private List<CodigoPromocional> codigos;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
        codigo = new CodigoPromocional();
        usuarioDAO = new UsuarioDAOImpl();
        promocionDAO = new PromocionDAOImpl();
        codigos = promocionDAO.codigos();
        listaUsuarios = usuarioDAO.nombreUsuarios();

    }

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

    private Boolean esAdmin(){
        if (promocionDAO.codigoPromocional(codigo.getCodigo()) != null){
            usuario.setTipo("A");
            return true;
        }else{
            usuario.setTipo("O");
            return false;
        }
    }

    public void existeUsuario() throws UsuarioNoDisponible{
        if(listaUsuarios.contains(usuario.getUsuario())){
            throw new UsuarioNoDisponible();
        }
    }

    public void registrar(){
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

        }catch (UsuarioNoDisponible e){

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Aviso", "Ese nombre de usuario ya esta cogido, por favor introduzca otro"));

        }catch (Exception  e){

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Aviso", "Error!"));
        }
    }


}
