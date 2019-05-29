package org.brujula.Model;

import org.hibernate.annotations.Cascade;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "alquilerModel")
@Entity
@Table(name = "alquileres")
public class Alquiler implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Integer idAlquiler;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @OneToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula idPelicula;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlquiler;

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idPersona) {
        this.idUsuario = idUsuario;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
}
