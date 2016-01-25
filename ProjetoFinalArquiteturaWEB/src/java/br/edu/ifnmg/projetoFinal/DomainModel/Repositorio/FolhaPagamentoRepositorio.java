/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DomainModel.Repositorio;

import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.FolhaPagamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Igor
 */
@Local
public interface FolhaPagamentoRepositorio extends Repositorio<FolhaPagamento> {

    public List<ContraCheque> valorTotal(FolhaPagamento folhaPagamento);
}
