/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Acrescimo;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.AcrescimoRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "acrescimoController")
@SessionScoped
public class AcrescimoController extends ControllerGenerico<Acrescimo> implements Serializable {

    /**
     * Creates a new instance of AcrescimoController
     */
    @EJB
    private AcrescimoRepositorio repositorio;

    public AcrescimoController() {
        super("ListaAcrescimo.xhtml", "DadosAcrescimo.xhtml", "NovoAcrescimo.xhtml");
        entidade = new Acrescimo();
        filtro = new Acrescimo();
    }

    @Override
    public String limparfiltros() {
        filtro = new Acrescimo();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Acrescimo();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
