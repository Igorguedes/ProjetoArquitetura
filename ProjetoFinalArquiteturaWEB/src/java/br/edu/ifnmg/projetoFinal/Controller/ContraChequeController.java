/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Acrescimo;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.ContraChequeRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.Desconto;
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
@Named(value = "contraChequeController")
@SessionScoped
public class ContraChequeController extends ControllerGenerico<ContraCheque> implements Serializable {

    /**
     * Creates a new instance of ContraChequeController
     */
    @EJB
    private ContraChequeRepositorio repositorio;

    public ContraChequeController() {
        super("ListaContraCheque.xhtml", "", "NovoContraCheque.xhtml");
        entidade = new ContraCheque();
        filtro = new ContraCheque();
    }

    public String apagarContraCheque(ContraCheque contraCheque) {
        if (repositorio.Apagar(contraCheque)) {
            MensagemSucesso("Sucesso!", "Registro removido com sucesso!");
            return "ListaContraCheque.xhtml";
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return null;
        }
    }

    @Override
    public String salvar() {
        Double porcAcrescimo = 0.00, porcDesconto = 0.00;
        List<Acrescimo> listaAcrescimo = repositorio.totalAcrescimo(entidade);
        List<Desconto> listaDesconto = repositorio.totalDesconto(entidade);
        for (Acrescimo acrescimo : listaAcrescimo) {
            porcAcrescimo += acrescimo.getPorcentagem() / 100;
        }
        for (Desconto desconto : listaDesconto) {
            porcDesconto += desconto.getPorcentagem() / 100;
        }
        entidade.setTotalAcrescimo(entidade.getFuncionario().getSalario() * porcAcrescimo);
        entidade.setTotalDesconto(entidade.getFuncionario().getSalario() * porcDesconto);
        entidade.setSalarioBruto(entidade.getFuncionario().getSalario());
        Double salarioLiquido = entidade.getFuncionario().getSalario() + entidade.getTotalAcrescimo();
        salarioLiquido = salarioLiquido - entidade.getTotalDesconto();
        entidade.setSalarioLiquido(salarioLiquido);
        return super.salvar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new ContraCheque();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
