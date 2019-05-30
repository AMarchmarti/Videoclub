package org.brujula.Model;


import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "generos")
public class Genero implements Serializable {

    @Id
    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
