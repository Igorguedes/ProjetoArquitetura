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
        super("", "", "");
        entidade = new Secretaria();
        filtro = new Secretaria();
    }

    @Override
    public String apagar() {
        if (repositorio.Apagar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro removido com sucesso!");
            entidade = new Secretaria();
            return "NovaSecretaria.xhtml";
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return null;
        }
    }

    @Override
    public String editar() {
        if (repositorio.Refresh(entidade)) {
            MensagemSucesso("Sucesso!", "Registro alterado com sucesso!");
            return "DadosSecretaria.xhtml";
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return null;
        }
    }

    @Override
    public String salvar() {
        if (repositorio.Salvar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro salvo com sucesso!");
            List<Secretaria> lista = repositorio.Buscar(new Secretaria());
            entidade = lista.get(0);
            return "DadosSecretaria.xhtml";
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return "";
        }
    }

    public String verificarCadastro() {
        List<Secretaria> lista = repositorio.Buscar(new Secretaria());
        if (lista.isEmpty()) {
            return "NovaSecretaria.xhtml";
        } else {
            entidade = lista.get(0);
            return "DadosSecretaria.xhtml";
        }
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
