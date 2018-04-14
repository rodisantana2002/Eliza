/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaparadigmas.control;

import aulaparadigmas.core.Component;
import java.util.List;

/**
 *
 * @author rodolfosmac
 */
public abstract class Operador implements Component{
    private List<Component> components;
        
    public Operador(List<Component> components){
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public String toString(){
        StringBuilder strExpressao = new StringBuilder(" ( ");
        strExpressao.append(getSimbolo() + " ");
        for(Component component : components){
            strExpressao.append(component.toString());
            strExpressao.append(" ");
        }
        strExpressao.append(") ");
        return strExpressao.toString();
    }        
    
    public abstract String getSimbolo();
    public abstract double avaliar();
}
