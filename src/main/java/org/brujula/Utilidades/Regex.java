package org.brujula.Utilidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public enum Regex implements Serializable {

    CONTRASEÑA("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$"),
    EMAIL("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
    TELEFONO("(\\+?\\d[- .]*){7,13}"),
    DNI("^[0-9]{8}[^IÑOU]"),
    NOMBRE("[a-zA-Z0-9]+");

    private String regex;

    Regex(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
