/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Acrescimo;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.AcrescimoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Jardel
 */
@Singleton
public class AcrescimoDAO extends DAOGenerico<Acrescimo> implements AcrescimoRepositorio {

    public AcrescimoDAO() {
        super(Acrescimo.class);
    }

    @Override
    public List<Acrescimo> Buscar(Acrescimo filtro) {
        return OrderBy("id", "ASC")
                .Buscar();
    }

}
