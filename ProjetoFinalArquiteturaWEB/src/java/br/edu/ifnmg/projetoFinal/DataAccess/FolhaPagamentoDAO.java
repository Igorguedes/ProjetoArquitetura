/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.FolhaPagamento;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.FolhaPagamentoRepositorio;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

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
                .Buscar();
    }

    @Override
    public List<ContraCheque> valorTotal(FolhaPagamento folhaPagamento) {
        try {
            if (folhaPagamento != null) {
                String Consulta = "select o from ContraCheque o ";
                Consulta = Consulta + " where o.mes = " + Integer.toString(folhaPagamento.getMes()) + " ";
                Consulta = Consulta + " and o.ano = " + Integer.toString(folhaPagamento.getAno()) + " ";
                Query query = manager.createQuery(Consulta);
                return query.getResultList();
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

}
