package org.brujula.Model;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.*;
import java.util.Objects;

@ManagedBean(name = "peliculaModel")
@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column
    private String titulo;

    @Column
    private String resumen;

    @Column
    private Boolean estado = true;

    @ManyToOne
    @JoinColumn(name = "genero")
    private Genero genero;

   
    @Column
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPelicula, pelicula.idPelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula);
    }
}
