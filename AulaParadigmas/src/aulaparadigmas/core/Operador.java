/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaparadigmas.core;

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
        StringBuilder strExpressao = new StringBuilder(" (");
        strExpressao.append(getSimbolo() + " ");
        int itens =(components.size()-1);
        
        for(Component component : components){
            strExpressao.append(component.toString());
            if (components.indexOf(component) < itens){
                strExpressao.append(" ");                
            }
        }
        strExpressao.append(") ");
        return strExpressao.toString();
    }        
    
    public abstract String getSimbolo();
    public abstract double avaliar();
}
