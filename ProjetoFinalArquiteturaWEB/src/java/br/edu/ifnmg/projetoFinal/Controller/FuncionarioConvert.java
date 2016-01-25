/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Funcionario;
import br.edu.ifnmg.projetoFinal.DomainModel.Gratificacao;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FuncionarioRepositorio;
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
@Named(value = "funcionarioConvert")
@SessionScoped
public class FuncionarioConvert implements Serializable, Converter {

    /**
     * Creates a new instance of FuncionarioConvert
     */
    @EJB
    private FuncionarioRepositorio repositorio;

    public FuncionarioConvert() {
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
            Funcionario funcionario = (Funcionario) value;
            if (funcionario.getId() == null) {
                return null;
            }
            return funcionario.getId().toString();
        }
    }

}
