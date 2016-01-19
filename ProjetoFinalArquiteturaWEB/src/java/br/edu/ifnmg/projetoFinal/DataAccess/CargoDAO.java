/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Cargo;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.CargoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Igor
 */
@Singleton
public class CargoDAO extends DAOGenerico<Cargo> implements CargoRepositorio {

    public CargoDAO() {
        super(Cargo.class);
    }

    @Override
    public List<Cargo> Buscar(Cargo filtro) {
        if (filtro != null) {
            return this.Like("nome", filtro.getNome())
                    .IgualA("id", filtro.getId())
                    .Buscar();

        }
        return this.Buscar();
    } 
}
