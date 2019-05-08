package org.brujula.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Personas {
    private Integer id;
    private String nombre;
    private String apellidos;
    private Object sexo;
    private Timestamp fechaNacimiento;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "sexo")
    public Object getSexo() {
        return sexo;
    }

    public void setSexo(Object sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "fechaNacimiento")
    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personas personas = (Personas) o;
        return Objects.equals(id, personas.id) &&
                Objects.equals(nombre, personas.nombre) &&
                Objects.equals(apellidos, personas.apellidos) &&
                Objects.equals(sexo, personas.sexo) &&
                Objects.equals(fechaNacimiento, personas.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, sexo, fechaNacimiento);
    }
}
