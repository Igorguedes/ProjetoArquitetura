/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DomainModel.Repositorio;

import br.edu.ifnmg.projetoFinal.DomainModel.Acrescimo;
import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.Desconto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Igor
 */
@Local
public interface ContraChequeRepositorio extends Repositorio<ContraCheque> {

    public List<Acrescimo> totalAcrescimo(ContraCheque contraCheque);

    public List<Desconto> totalDesconto(ContraCheque contraCheque);
}
