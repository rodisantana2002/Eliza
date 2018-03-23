/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author rodolfosmac
 */
public class Rule {

            
    public String name;
    public Clause antecedents[];  // allow up to 4 antecedents for now
    public Clause consequent;     //only 1 consequent clause allowed
    public Boolean truth;       // states = (null=unknown, true, or false)
    public boolean fired = false;
    public BooleanRuleBase rb;

    
   
    public Rule(BooleanRuleBase Rb, String Name, Clause lhs, Clause rhs) {
        this.rb = Rb;
        name = Name;
        antecedents = new Clause[1];
        antecedents[0] = lhs;
        lhs.addRuleRef(this);
        consequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConsequent();
        rb.ruleList.addElement(this);  // add self to rule list
        truth = null;
    }

    public Rule(BooleanRuleBase Rb, String Name, Clause[] lhsClauses, Clause rhs) {
        this.rb = Rb;
        this.name = Name;
        
        antecedents = new Clause[lhsClauses.length];
        for (int i = 0; i <lhsClauses.length; i++){
            antecedents[i] = lhsClauses[i];
            antecedents[i].addRuleRef(this);
        }
        consequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConsequent();
        rb.ruleList.addElement(this);
        truth = null;
    }

    public long numAntecedents() {
        return antecedents.length;
    }
    
    public Boolean check(){
        rb.trace("\nTesting rule " + name);
        
        for(int i=0; i <antecedents.length;i++){
            if(antecedents[i].truth = null){
                return truth = null;
            }
            if(antecedents[i].truth.booleanValue() == true){
                continue;
            }
            else{
                return truth = new Boolean(false);
            }
        }
        return truth = new Boolean(true);
    }
    
    public void fire(){
        rb.trace("\nFiring rule " + name);
        truth = new Boolean(true);
        fired = true;
        consequent.lhs.setValue(consequent.rhs);
        checkRules(consequent.lhs.clauseRefs);
    }
    
    public static void checkRules(Vector clauseRefs){
        Enumeration enums = clauseRefs.elements();
        
        while(enums.hasMoreElements()){
            Clause temp = (Clause) enums.nextElement();
            Enumeration enums2 = temp.ruleRefs.elements();
            while(enums2.hasMoreElements()){
                ((Rule) enums2.nextElement()).check();
            }
        }
    }
    
    public void display(JTextArea textArea){
        textArea.append(name + ": IF ");
        for (int i =0; i<antecedents.length; i++){
            Clause nextClause = antecedents[i];
            
            textArea.append(nextClause.toString());
            if((i + 1) < antecedents.length){
                textArea.append("\n    AND ");
            }            
        }
        textArea.append("\n    THEN ");
        textArea.append(consequent.toString() + "\n");
    }
    
    public Boolean backChain(){
        rb.trace("\nEvaluating rule " + name);
        for(int i=0;i< antecedents.length; i++){
            if(antecedents[i].truth == null){
                rb.backwardChain(antecedents[i].lhs.name);                
            }
            if(antecedents[i].truth == null){
                antecedents[i].lhs.askUser();
                truth = antecedents[i].check();
            }
            if(antecedents[i].truth.booleanValue() == true){
                continue;
            }
            else{
                return truth = new Boolean(false);
            }            
        }
        return truth = new Boolean(true);
    }    
}



