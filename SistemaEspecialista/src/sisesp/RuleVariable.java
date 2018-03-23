/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author rodolfosmac
 */
public class RuleVariable extends Variable {
    protected BooleanRuleBase rb;
    protected Vector clauseRefs;
    protected String promptText;
    protected String ruleName;


    public RuleVariable(BooleanRuleBase rb, String Name) {
        super(Name);
        this.rb = rb;
        //rb.addVariable(this);
        clauseRefs = new Vector();
    }

    public void setValue(String val) {
        value = val;
        updateClauses();
    }

    // prompt a user to provide a value for a variable during inferencing
    public String askUser() {
        String answer = null;
        JFrame frame = new JFrame();
//        RuleVarDialog dlg = new RuleVarDialog(frame, "Ask User for Value", true);
//        
//        dlg.setLocation(200,200);
//        dlg.setData(this);
//        dlg.show();
//        answer = dlg.getData();
        
        setValue(answer);
        return value;
    }

    public void addClauseRef(Clause ref) {
        clauseRefs.addElement(ref);
    }

    public void updateClauses() {
        Enumeration enums = clauseRefs.elements();
        
        while (enums.hasMoreElements()) {
            ((Clause) enums.nextElement()).check(); // retest the clause
        }
    }
    public void setRuleName(String rname) {
        ruleName = rname;
    }
    
    public void setPromptText(String promptText){
        this.promptText = promptText;
    }
    
    public String getPromptText(){
        return promptText;
    }
    
    public void computeStatistics(String inValue){}
    
    public int normalize(String inValue, float[] outArray, int inx){
        return inx;
    }
}
