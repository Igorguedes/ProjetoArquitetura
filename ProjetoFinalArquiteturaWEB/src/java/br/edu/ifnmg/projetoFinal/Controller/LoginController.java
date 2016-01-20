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
import java.util.Enumeration;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
        super("ListaUsuario.xhtml", "DadosLogin.xhtml", "NovoLogin.xhtml");
        entidade = new Login();
        filtro = new Login();
    }

    @Override
    public String limparfiltros() {
        filtro = new Login();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Login();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean visibilidadeCoordenador() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Login login = (Login) session.getAttribute("login");
        if (login.getNivel().equals("Coordenador")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean visibilidadeAdministrador() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Login login = (Login) session.getAttribute("login");
        if (login.getNivel().equals("Administrador")) {
            return true;
        } else {
            return false;
        }
    }

    public String sair() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute("login", null);
        Enumeration<String> vals = session.getAttributeNames();
        while (vals.hasMoreElements()) {
            session.removeAttribute(vals.nextElement());
        }
        return "/index.xhtml";
    }

    public String login() {
        List<Login> lista = repositorio.Buscar(new Login());
        if (lista.isEmpty()) {
            entidade.setNivel("Administrador");
            repositorio.Salvar(entidade);
            return "/public/index.xhtml";
        }
        Login login = repositorio.Login(entidade);
        if (login != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("login", login);
            return "/public/index.xhtml";
        } else {
            MensagemErro("Erro!", "Dados Inválido!");
            return "";
        }
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
