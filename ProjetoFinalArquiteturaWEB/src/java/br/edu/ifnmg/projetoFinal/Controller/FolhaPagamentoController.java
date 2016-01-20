/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FolhaPagamentoRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.FolhaPagamento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "folhaPagamentoController")
@SessionScoped
public class FolhaPagamentoController extends ControllerGenerico<FolhaPagamento> implements Serializable {

    /**
     * Creates a new instance of FolhaPagamentoController
     */
    @EJB
    private FolhaPagamentoRepositorio repositorio;

    public FolhaPagamentoController() {
        super("ListaFolhaPagamento.xhtml", "DadosFolhaPagamento.xhtml", "NovoFolhaPagamento.xhtml");
        entidade = new FolhaPagamento();
        filtro = new FolhaPagamento();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
