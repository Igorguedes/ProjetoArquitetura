/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.FolhaPagamento;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FolhaPagamentoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class FolhaPagamentoDAO extends DAOGenerico<FolhaPagamento> implements FolhaPagamentoRepositorio {

    public FolhaPagamentoDAO() {
        super(FolhaPagamento.class);
    }

    @Override
    public List<FolhaPagamento> Buscar(FolhaPagamento filtro) {
        return IgualA("id", filtro.getId())
                .OrderBy("data", "ASC")
                .Buscar();
    }

}
