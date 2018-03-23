/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author rodolfosmac
 */
public interface RuleBase {
    public void setDisplay(JTextArea textArea);
    public void trace(String test);
    public void displayVariables(JTextArea textArea);
    public void reset();
    public void backwardChain(String goalVarName);
    public void forwardChain();
    public Vector getGoalVariables();
}
