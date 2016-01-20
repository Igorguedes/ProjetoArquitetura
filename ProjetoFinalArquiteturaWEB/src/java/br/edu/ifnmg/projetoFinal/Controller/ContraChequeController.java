/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.ContraChequeRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
        super("ListaContraCheque.xhtml", "DadosContraCheque.xhtml", "NovoContraCheque.xhtml");
        entidade = new ContraCheque();
        filtro = new ContraCheque();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
