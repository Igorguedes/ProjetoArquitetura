/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Desconto;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.DescontoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Jardel
 */
@Singleton
public class DescontoDAO extends DAOGenerico<Desconto> implements DescontoRepositorio {

    public DescontoDAO() {
        super(Desconto.class);
    }

    @Override
    public List<Desconto> Buscar(Desconto filtro) {
        return OrderBy("id", "ASC")
                .Buscar();
    }

}
