package org.brujula.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "telefonos")
public class Telefono {
    private Integer id;
    private String numero;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numero")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefonos = (Telefono) o;
        return Objects.equals(id, telefonos.id) &&
                Objects.equals(numero, telefonos.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero);
    }
}
