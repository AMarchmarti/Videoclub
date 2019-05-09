package org.brujula.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona idUsuario;

    @Column
    private String usuario;

    @Column
    private String clave;

    @Column
    private String tipo;

    @Column
    private Short estado = 1;

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
}
