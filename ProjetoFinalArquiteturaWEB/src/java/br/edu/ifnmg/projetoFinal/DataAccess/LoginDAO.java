/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Login;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.LoginRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author André Fellype
 */
@Singleton
public class LoginDAO extends DAOGenerico<Login> implements LoginRepositorio {

    public LoginDAO() {
        super(Login.class);
    }

    @Override
    public List<Login> Buscar(Login filtro) {
        return Like("usuario", filtro.getUsuario())
                .IgualA("login", "ASC")
                .Buscar();
    }

}
