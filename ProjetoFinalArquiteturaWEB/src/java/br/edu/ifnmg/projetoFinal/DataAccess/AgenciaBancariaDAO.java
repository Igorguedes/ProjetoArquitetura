/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.AgenciaBancaria;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.AgenciaBancariaRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */

@Singleton
public class AgenciaBancariaDAO  extends DAOGenerico<AgenciaBancaria> implements AgenciaBancariaRepositorio{

   
    public AgenciaBancariaDAO() {
        super(AgenciaBancaria.class);
    }

    @Override
    public List<AgenciaBancaria> Buscar(AgenciaBancaria filtro) {
        if (filtro != null) {
            return this.Like("nome", filtro.getNome())
                    .IgualA("id", filtro.getId())
                    .Buscar();
        }
        return this.Buscar();
    
    }
    
}
