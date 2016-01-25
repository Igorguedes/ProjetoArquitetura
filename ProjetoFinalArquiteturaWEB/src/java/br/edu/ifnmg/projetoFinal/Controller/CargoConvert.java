/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Cargo;
import static br.edu.ifnmg.projetoFinal.DomainModel.Cargo_.gratificacao;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.CargoRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author andre
 */
@Named(value = "cargoConvert")
@SessionScoped
public class CargoConvert implements Serializable, Converter {

    /**
     * Creates a new instance of CargoConvert
     */
    @EJB
    private CargoRepositorio repositorio;

    public CargoConvert() {
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
            Cargo cargo = (Cargo) value;
            if (cargo.getId() == null) {
                return null;
            }
            return cargo.getId().toString();
        }
    }

}
