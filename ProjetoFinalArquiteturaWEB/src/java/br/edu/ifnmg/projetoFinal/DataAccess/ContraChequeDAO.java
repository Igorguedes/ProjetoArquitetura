/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.ContraChequeRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class ContraChequeDAO extends DAOGenerico<ContraCheque> implements ContraChequeRepositorio {

    public ContraChequeDAO() {
        super(ContraCheque.class);
    }

    @Override
    public List<ContraCheque> Buscar(ContraCheque filtro) {
        return IgualA("id", filtro.getId())
                .OrderBy("data", "ASC")
                .Buscar();
    }

}
