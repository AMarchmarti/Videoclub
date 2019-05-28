package org.brujula.Controller.Sesiones;

import org.brujula.Utilidades.Regex;
import org.primefaces.validate.ClientValidator;
import sun.security.validator.ValidatorException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

import java.io.Serializable;
import java.util.Map;
import java.util.regex.Pattern;

@ManagedBean
@ViewScoped
public class ValidationController implements Serializable, Validator, ClientValidator {

    private Pattern pattern;

    public void setPattern(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void validate(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return;
        }

        if(!getPattern().matcher(value.toString()).matches()) {
            try {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error",
                        value + " is not a valid email;"));
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, Object> getMetadata() {
        return null;
    }

    public String getValidatorId() {
        return "custom.validator";
    }


}

