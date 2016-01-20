/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.SecretariaRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Secretaria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author André Fellype
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
        super("ListaSecretaria.xhtml", "DadosSecretaria.xhtml", "NovoSecretaria.xhtml");
        entidade = new Secretaria();
        filtro = new Secretaria();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
