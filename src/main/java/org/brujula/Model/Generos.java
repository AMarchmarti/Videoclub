package org.brujula.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Generos {
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
        Generos generos = (Generos) o;
        return Objects.equals(idGenero, generos.idGenero) &&
                Objects.equals(nombre, generos.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenero, nombre);
    }
}
