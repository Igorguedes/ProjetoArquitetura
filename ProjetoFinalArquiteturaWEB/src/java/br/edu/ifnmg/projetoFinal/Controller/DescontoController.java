/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Desconto;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.DescontoRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "descontoController")
@SessionScoped
public class DescontoController extends ControllerGenerico<Desconto> implements Serializable {

    /**
     * Creates a new instance of DescontoController
     */
    @EJB
    private DescontoRepositorio repositorio;

    public DescontoController() {
        super("ListaDesconto.xhtml", "DadosDesconto.xhtml", "NovoDesconto.xhtml");
        entidade = new Desconto();
        filtro = new Desconto();
    }

    @Override
    public String limparfiltros() {
        filtro = new Desconto();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Desconto();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
