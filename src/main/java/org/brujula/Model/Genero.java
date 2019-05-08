package org.brujula.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "generos")
public class Genero {
    private Integer idGenero;
    private String nombre;

    @Id
    @Column(name = "id_genero")
    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero generos = (Genero) o;
        return Objects.equals(idGenero, generos.idGenero) &&
                Objects.equals(nombre, generos.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenero, nombre);
    }
}
