package org.brujula.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Alquileres {
    private Integer idAlquiler;
    private Timestamp fechaAlquiler;

    @Id
    @Column(name = "id_alquiler")
    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    @Basic
    @Column(name = "fechaAlquiler")
    public Timestamp getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Timestamp fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alquileres that = (Alquileres) o;
        return Objects.equals(idAlquiler, that.idAlquiler) &&
                Objects.equals(fechaAlquiler, that.fechaAlquiler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlquiler, fechaAlquiler);
    }
}
