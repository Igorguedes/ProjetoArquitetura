/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.LoginRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Login;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController extends ControllerGenerico<Login> implements Serializable {

    /**
     * Creates a new instance of LoginController
     */
    @EJB
    private LoginRepositorio repositorio;

    public LoginController() {
        super("ListaLogin.xhtml", "DadosLogin.xhtml", "NovoLogin.xhtml");
        entidade = new Login();
        filtro = new Login();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
