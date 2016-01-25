/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.SecretariaRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Secretaria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Jardel
 */
@Named(value = "secretariaController")
@SessionScoped
public class SecretariaController extends ControllerGenerico<Secretaria> implements Serializable {

    /**
     * Creates a new instance of SecretariaController
     */
    @EJB
    private SecretariaRepositorio repositorio;

    public SecretariaController() {
        super("ListaSecretaria.xhtml", "DadosSecretaria.xhtml", "NovaSecretaria.xhtml");
        entidade = new Secretaria();
        filtro = new Secretaria();
    }

    @Override
    public String limparfiltros() {
        filtro = new Secretaria();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Secretaria();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
