/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.GratificacaoRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Gratificacao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "gratificacaoController")
@SessionScoped
public class GratificacaoController extends ControllerGenerico<Gratificacao> implements Serializable {

    /**
     * Creates a new instance of GratificacaoController
     */
    @EJB
    private GratificacaoRepositorio repositorio;

    public GratificacaoController() {
        super("ListaGratificacao.xhtml", "DadosGratificacao.xhtml", "NovaGratificacao.xhtml");
        entidade = new Gratificacao();
        filtro = new Gratificacao();
    }

    @Override
    public String limparfiltros() {
        filtro = new Gratificacao();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Gratificacao();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
