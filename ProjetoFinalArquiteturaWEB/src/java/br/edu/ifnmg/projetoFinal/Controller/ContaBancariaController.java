/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.ContaBancariaRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.ContaBancaria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author André Fellype
 */
@Named(value = "contaBancariaController")
@SessionScoped
public class ContaBancariaController extends ControllerGenerico<ContaBancaria> implements Serializable {

    /**
     * Creates a new instance of ContaBancariaController
     */
    @EJB
    private ContaBancariaRepositorio repositorio;

    public ContaBancariaController() {
        super("ListaContaBancaria.xhtml", "DadosContaBancaria.xhtml", "NovoContaBancaria.xhtml");
        entidade = new ContaBancaria();
        filtro = new ContaBancaria();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
