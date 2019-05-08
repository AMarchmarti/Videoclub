package org.brujula.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Usuario {
    private Integer idPersona;
    private String usuario;
    private String clave;
    private Object tipo;
    private Boolean estado;

    @Id
    @Column(name = "id_persona")
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "clave")
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "tipo")
    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "estado")
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(idPersona, usuario1.idPersona) &&
                Objects.equals(usuario, usuario1.usuario) &&
                Objects.equals(clave, usuario1.clave) &&
                Objects.equals(tipo, usuario1.tipo) &&
                Objects.equals(estado, usuario1.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, usuario, clave, tipo, estado);
    }
}
