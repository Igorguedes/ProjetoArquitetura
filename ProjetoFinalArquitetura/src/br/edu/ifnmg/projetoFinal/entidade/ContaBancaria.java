/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoFinal.entidade;

/**
 *
 * @author Igor
 */
public class ContaBancaria {
    private Long id;
    private String numeroConta;
    private AgenciaBancaria agenciaBancaria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public AgenciaBancaria getAgenciaBancaria() {
        return agenciaBancaria;
    }

    public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }
    
    
}
