/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite.control;

import composite.core.Operador;
import composite.core.Component;
import java.util.List;

/**
 *
 * @author rodolfosmac
 */
public class Divisao extends  Operador {

    public Divisao(List<Component> components){
        super(components);
    }
    
    @Override
    public double avaliar() {
        double valor = 1;
        for(Component comp: getComponents()){
            valor /= comp.avaliar();
        }
        
        return valor;
    }
    
    @Override
    public String getSimbolo() {
        return "/";
    }
    
}
