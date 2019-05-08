package org.brujula.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Peliculas {
    private Integer idPelicula;
    private String titulo;
    private String resumen;
    private Byte estado;

    @Id
    @Column(name = "id_pelicula")
    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Basic
    @Column(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "resumen")
    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Basic
    @Column(name = "estado")
    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peliculas peliculas = (Peliculas) o;
        return Objects.equals(idPelicula, peliculas.idPelicula) &&
                Objects.equals(titulo, peliculas.titulo) &&
                Objects.equals(resumen, peliculas.resumen) &&
                Objects.equals(estado, peliculas.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, titulo, resumen, estado);
    }
}
