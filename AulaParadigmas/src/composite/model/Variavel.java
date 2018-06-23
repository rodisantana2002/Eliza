/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite.model;

import composite.core.Operando;

/**
 *
 * @author rodolfosmac
 */
public class Variavel extends Operando {
    private String nome; 
        
    public Variavel(String nome, double valor){
        super(valor);
        this.nome = nome;
    }

    public String toString() {
        return nome;
    }    
}
