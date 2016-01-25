/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FolhaPagamentoRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.FolhaPagamento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
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
        super("ListaFolhaPagamento.xhtml", "", "NovaFolhaPagamento.xhtml");
        entidade = new FolhaPagamento();
        filtro = new FolhaPagamento();
    }

    @Override
    public String salvar() {
        Double total = 0.00;
        List<ContraCheque> lista = repositorio.valorTotal(entidade);
        for (ContraCheque contraCheque : lista) {
            total += contraCheque.getSalarioLiquido();
        }
        entidade.setValorTotal(total);
        return super.salvar(); //To change body of generated methods, choose Tools | Templates.
    }

    public String apagarFolha(FolhaPagamento folhaPagamento) {
        if (repositorio.Apagar(folhaPagamento)) {
            MensagemSucesso("Sucesso!", "Registro removido com sucesso!");
            return paginaListagem;
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return null;
        }
    }

    @Override
    public String novo() {
        entidade = new FolhaPagamento();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
