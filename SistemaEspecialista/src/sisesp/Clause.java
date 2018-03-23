/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

import java.util.Vector;

/**
 *
 * @author rodolfosmac
 */
public class Clause {

    Vector ruleRefs;
    RuleVariable lhs;
    String rhs;
    Condition cond;
    Boolean consequent;  // true or false
    Boolean truth;   // states = null(unknown), true or false

    public Clause(){}
    
    public Clause(RuleVariable Lhs, Condition Cond, String Rhs) {
        this.lhs = Lhs;
        this.cond = Cond;
        this.rhs = Rhs;
        lhs.addClauseRef(this);
        ruleRefs = new Vector();
        truth = null;
        consequent = new Boolean(false);
    }

    public void addRuleRef(Rule ref) {
        ruleRefs.addElement(ref);
    }

    public String toString(){
        return lhs.name + cond.toString() + rhs + " ";
    }
    
    public Boolean check() {
        if (consequent == true) {
            return truth = null;
        }
        if (lhs.value == null) {
            return truth = null;  // var value is undefined
        } else {

            Double lhsNumericValue = null;
            Double rhsNumericValue = null;
            boolean bothNumeric = true;
            
            try{
                lhsNumericValue = Double.valueOf(lhs.value);
                rhsNumericValue = Double.valueOf(rhs);
            }
            catch(Exception e){
                bothNumeric= false;                
            }            
            
            switch (cond.index) {
                case 1:
                    if(bothNumeric){
                        truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)==0);
                    }
                    else{
                        truth = new Boolean(lhs.value.equalsIgnoreCase(rhs));
                    }
                    break;
                case 2:
                    if(bothNumeric){
                        truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)>0);
                    }
                    else{
                        truth = new Boolean(lhs.value.compareTo(rhs)>0);
                    }
                    break;
                case 3:
                    if(bothNumeric){
                        truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)<0);
                    }
                    else{
                        truth = new Boolean(lhs.value.compareTo(rhs)<0);
                    }
                    break;
                case 4:
                    if(bothNumeric){
                        truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)!=0);
                    }
                    else{
                        truth = new Boolean(lhs.value.compareTo(rhs)!=0);
                    }
                    break;
            }

            return truth;
        }
    }

    public void setConsequent() {
        consequent = true;
    }

    public Rule getRule() {
        if (consequent) {
            return (Rule) ruleRefs.firstElement();
        } else {
            return null;
        }
    }
}
