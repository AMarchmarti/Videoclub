package org.brujula.Model;


import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@ManagedBean(name = "usuarioModel")
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dni_persona", nullable = false)
    private Persona idUsuario;

    @Column
    private String usuario;

    @Column
    private String clave;

    @Column
    private String tipo;

    @Column
    private Short estado = 1;

    public Integer getId() {
        return id;
    }

    public Persona getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Persona idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                '}';
    }
}
