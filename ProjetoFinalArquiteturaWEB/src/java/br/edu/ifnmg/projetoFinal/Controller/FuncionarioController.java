/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FuncionarioRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Funcionario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "funcionarioController")
@SessionScoped
public class FuncionarioController extends ControllerGenerico<Funcionario> implements Serializable {

    /**
     * Creates a new instance of FuncionarioController
     */
    @EJB
    private FuncionarioRepositorio repositorio;

    public FuncionarioController() {
        super("ListaFuncionario.xhtml", "DadosFuncionario.xhtml", "NovoFuncionario.xhtml");
        entidade = new Funcionario();
        filtro = new Funcionario();
    }

    @Override
    public String limparfiltros() {
        filtro = new Funcionario();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Funcionario();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
