/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Funcionario;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FuncionarioRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements FuncionarioRepositorio {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario filtro) {
        return Like("nome", filtro.getNome())
                .Like("cpf", filtro.getCPF())
                .Like("rg", filtro.getRG())
                .IgualA("id", filtro.getId())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
