/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.SecretariaRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Secretaria;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class SecretariaDAO extends DAOGenerico<Secretaria> implements SecretariaRepositorio {

    public SecretariaDAO() {
        super(Secretaria.class);
    }

    @Override
    public List<Secretaria> Buscar(Secretaria filtro) {
        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .Buscar();
    }

}
