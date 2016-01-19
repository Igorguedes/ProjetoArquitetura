/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Gratificacao;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.GratificacaoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class GratificacaoDAO extends DAOGenerico<Gratificacao> implements GratificacaoRepositorio {

    public GratificacaoDAO() {
        super(Gratificacao.class);
    }

    @Override
    public List<Gratificacao> Buscar(Gratificacao filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

}
