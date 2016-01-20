/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.Controller;

import br.edu.ifnmg.projetoFinal.DomainModel.Repositorio.CargoRepositorio;
import br.edu.ifnmg.projetoFinal.DomainModel.Cargo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Jardel
 */
@Named(value = "cargoController")
@SessionScoped
public class CargoController extends ControllerGenerico<Cargo> implements Serializable {

    /**
     * Creates a new instance of CargoController
     */
    @EJB
    private CargoRepositorio repositorio;

    public CargoController() {
        super("ListaCargo.xhtml", "DadosCargo.xhtml", "NovoCargo.xhtml");
        entidade = new Cargo();
        filtro = new Cargo();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
