/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaparadigmas.control;

import aulaparadigmas.core.Operador;
import aulaparadigmas.core.Component;
import java.util.List;

/**
 *
 * @author rodolfosmac
 */
public class Subtracao extends  Operador {

    public Subtracao(List<Component> components){
        super(components);
    }
    
    @Override
    public double avaliar() {
        double valor = 0;
        for(Component comp: getComponents()){
            valor -= comp.avaliar();
        }
        
        return valor;
    }
    
    @Override
    public String getSimbolo() {
        return "-";
    }
    
}
