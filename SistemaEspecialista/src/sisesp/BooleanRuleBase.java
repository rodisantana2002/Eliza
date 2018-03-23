/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author rodolfosmac
 */
public class BooleanRuleBase implements RuleBase{
    private String name;
    public Hashtable variableList = new Hashtable();
    public Clause clauseVarList[];
    public  Vector ruleList = new Vector();
    public Vector conclusionVarList;
    public Rule rulePtr;
    public Clause clausePtr;
    public Stack goalClauseStack = new Stack();
    //public Hashtable effectors;
    public Hashtable sensors;
    public Vector factList;
    public JTextArea textArea;
    
    public BooleanRuleBase(String name){
        this.name = name;
    }
    
    @Override
    public void setDisplay(JTextArea textArea) {
        this.textArea = this.textArea;
    }

    @Override
    public void trace(String text) {}

    @Override
    public void displayVariables(JTextArea textArea) {
        Enumeration enums = variableList.elements();
        while(enums.hasMoreElements()){
            RuleVariable temp = (RuleVariable) enums.nextElement();
            textArea.append("\n" + temp.name + " value = " + temp.value);
        }
    }
        
    public void displayConflictSet(Vector ruleSet){
        textArea.append("\n---Rules in conflit set:\n");
        Enumeration enums = ruleSet.elements();
        while (enums.hasMoreElements()){
            Rule temp = (Rule) enums.nextElement();
            textArea.append(temp.name + "(" + temp.numAntecedents() + "), ");
        }
    }

    @Override
    public void reset() {}

    @Override
    public void backwardChain(String goalVarName) {
        RuleVariable goalVar = (RuleVariable) variableList.get(goalVarName);
        Enumeration goalClauses = goalVar.clauseRefs.elements();
        
        while(goalClauses.hasMoreElements()){
            Clause goalClause = (Clause) goalClauses.nextElement();
            
            if(goalClause.consequent.booleanValue() == false){
                continue;
            }
            
            goalClauseStack.push(goalClause);
            Rule goalRule = goalClause.getRule();
            Boolean ruleTruth = goalRule.backChain();
            
            if(ruleTruth == null){
                trace("\nRule " + goalRule.name + " is null, can´t determine truth value.");
            }
            else{
                goalVar.setValue(goalClause.rhs);
                goalVar.setRuleName(goalRule.name);
                goalClauseStack.pop();
                trace("\nRule " + goalRule.name + " is true, setting " + goalVar.name + ": = " + goalVar.value);
                if(goalClauseStack.empty()){
                    trace("\n +++ Found Solution for goal: " + goalVar.name);
                    break;
                }
                else{
                    goalClauseStack.pop();
                    trace("\nRule " + goalRule.name + " is false, cant set " + goalVar.name);
                }
            }
        }
        if(goalVar.value ==null){
            trace("\n +++ Could Not Find Solution for goal: " + goalVar.name);            
        }
    }

    @Override
    public void forwardChain() {
        Vector conflitRuleSet = new Vector();
        
        conflitRuleSet = match(true);
        while(conflitRuleSet.size()>0){
            Rule selected = selectRule(conflitRuleSet);
            selected.fire();
            conflitRuleSet = match(false);
        }  
    }

    @Override
    public Vector getGoalVariables() {return null;}

    public Vector match(boolean test) {
        Vector matchList = new Vector();
        Enumeration enums = ruleList.elements();
        
        while(enums.hasMoreElements()){
            Rule testRule = (Rule) enums.nextElement();
            
            if(test){
                testRule.check();
            }
            if(testRule.truth == null){
                continue;
            }
            if((testRule.truth.booleanValue() == true) && (testRule.fired == false)){
                matchList.addElement(testRule);
            }
        }
        displayConflictSet(matchList);        
        return matchList;
    }
    
    
    public Rule selectRule(Vector ruleSet){
        Enumeration enums = ruleSet.elements();
        long numClauses;
        Rule nextRule;
        Rule bestRule = (Rule) enums.nextElement();
        long max = bestRule.numAntecedents();
        
        while (enums.hasMoreElements()){
            nextRule = (Rule) enums.nextElement();
            if((numClauses = nextRule.numAntecedents())>max){
                max = numClauses;
                bestRule = nextRule;
            }
        }
        return bestRule;
    }


}
