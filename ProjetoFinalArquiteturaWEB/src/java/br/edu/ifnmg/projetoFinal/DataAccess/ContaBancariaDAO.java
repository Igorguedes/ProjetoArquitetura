/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.ContaBancaria;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.ContaBancariaRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class ContaBancariaDAO extends DAOGenerico<ContaBancaria> implements ContaBancariaRepositorio {

    public ContaBancariaDAO() {
        super(ContaBancaria.class);
    }

    @Override
    public List<ContaBancaria> Buscar(ContaBancaria filtro) {
        return Like("numeroconta", filtro.getNumeroConta())
                .IgualA("agenciabancaria", filtro.getId())
                .IgualA("id", filtro.getId())
                .OrderBy("numeroconta", "ASC")
                .Buscar();
    }

}
