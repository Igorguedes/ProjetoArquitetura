/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.DataAccess;

import br.edu.ifnmg.projetoFinal.DomainModel.Acrescimo;
import br.edu.ifnmg.projetoFinal.DomainModel.ContraCheque;
import br.edu.ifnmg.projetoFinal.DomainModel.Desconto;
import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.ContraChequeRepositorio;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

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
                .Buscar();
    }

    @Override
    public List<Acrescimo> totalAcrescimo(ContraCheque contraCheque) {
        try {
            if (contraCheque != null) {
                String Consulta = "select o from Acrescimo o join o.funcionario u ";

                Consulta = Consulta + " where u.id = " + contraCheque.getFuncionario().getId().toString() + " ";
                Consulta = Consulta + " and o.mes = " + Integer.toString(contraCheque.getMes()) + " ";
                Consulta = Consulta + " and o.ano = " + Integer.toString(contraCheque.getAno()) + " ";
                Query query = manager.createQuery(Consulta);
                return query.getResultList();
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Desconto> totalDesconto(ContraCheque contraCheque) {
        try {
            if (contraCheque != null) {
                String Consulta = "select o from Desconto o join o.funcionario u ";

                Consulta = Consulta + " where u.id = " + contraCheque.getFuncionario().getId().toString() + " ";
                Consulta = Consulta + " and o.mes = " + contraCheque.getMes() + " ";
                Consulta = Consulta + " and o.ano = " + contraCheque.getAno()+ " ";
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
