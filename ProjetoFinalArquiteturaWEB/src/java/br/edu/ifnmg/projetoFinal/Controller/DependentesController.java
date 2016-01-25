/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.DependentesRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Dependentes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "dependentesController")
@SessionScoped
public class DependentesController extends ControllerGenerico<Dependentes> implements Serializable {

    /**
     * Creates a new instance of DependentesController
     */
    @EJB
    private DependentesRepositorio repositorio;

    public DependentesController() {
        super("ListaDependentes.xhtml", "DadosDependentes.xhtml", "NovoDependentes.xhtml");
        entidade = new Dependentes();
        filtro = new Dependentes();
    }

    @Override
    public String limparfiltros() {
        filtro = new Dependentes();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Dependentes();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
