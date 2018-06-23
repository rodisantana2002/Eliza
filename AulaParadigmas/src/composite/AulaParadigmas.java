/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import composite.control.Adicao;
import composite.control.Multiplicacao;
import composite.core.Component;
import composite.model.Numero;
import composite.model.Variavel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodolfosmac
 */
public class AulaParadigmas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereList
        List<Component> listaMultip = new ArrayList<Component>();
        List<Component> listaAdicao = new ArrayList<Component>();
        
        Component c1 = new Variavel("A", 30);
        Component c2 = new Numero(30);
        Component c3 = new Numero(15);
                                                                                                                                                                                    
        listaMultip.add(c1);
        listaMultip.add(c2);
        listaMultip.add(c3);
        
        Component c4 = new Multiplicacao(listaMultip);
        System.out.println(c4.toString());
        System.out.println(c4.avaliar());

        Component c5 = new Numero(5);
        Component c6 = new Numero(10);
        
        listaAdicao.add(c5);
        listaAdicao.add(c4);        
        listaAdicao.add(c6);

        Component c7 = new Adicao(listaAdicao);        
        System.out.println(c7.toString());
        System.out.println(c7.avaliar());        
    }    
}
