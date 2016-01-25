/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.SecretariaRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Secretaria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Jardel
 */
@Named(value = "secretariaConvert")
@SessionScoped
public class SecretariaConvert implements Serializable, Converter {

    /**
     * Creates a new instance of SecretariaConvert
     */
    @EJB
    private SecretariaRepositorio repositorio;

    public SecretariaConvert() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return repositorio.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            Secretaria secretaria = (Secretaria) value;
            if (secretaria.getId() == null) {
                return null;
            }
            return secretaria.getId().toString();
        }
    }

}
