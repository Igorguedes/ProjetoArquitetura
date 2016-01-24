/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.AgenciaBancariaRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.AgenciaBancaria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "agenciaBancariaController")
@SessionScoped
public class AgenciaBancariaController extends ControllerGenerico<AgenciaBancaria> implements Serializable {

    /**
     * Creates a new instance of AgenciaBancariaController
     */
    @EJB
    private AgenciaBancariaRepositorio repositorio;

    public AgenciaBancariaController() {
        super("ListaAgenciaBancaria.xhtml", "DadosAgenciaBancaria.xhtml", "NovaAgenciaBancaria.xhtml");
        entidade = new AgenciaBancaria();
        filtro = new AgenciaBancaria();
    }

    @Override
    public String limparfiltros() {
        filtro = new AgenciaBancaria();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new AgenciaBancaria();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
