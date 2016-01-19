/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Dependentes;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.DependentesRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class DependentesDAO extends DAOGenerico<Dependentes> implements DependentesRepositorio {

    public DependentesDAO() {
        super(Dependentes.class);
    }

    @Override
    public List<Dependentes> Buscar(Dependentes filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
