/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaparadigmas.core;

import aulaparadigmas.core.Component;

/**
 *
 * @author rodolfosmac
 */
public abstract class Operando implements Component{
    private double valor;
    
    public Operando(double valor){
        this.valor = valor;
    }
    
    public double avaliar(){
        return valor;
    }
    
    public String toString(){
        return String.valueOf(valor);
    }
}

