/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

/**
 *
 * @author rodolfosmac
 */
public class Condition {
    int index;
    String symbol;

    public Condition (String Symbol) {
        symbol = Symbol;
        if (Symbol.equals("=")) {
            index = 1;
        } else if (Symbol.equals(">")) {
            index = 2;
        } else if (Symbol.equals("<")) {
            index = 3;
        } else if (Symbol.equals("!=")) {
            index = 4;
        } else {
            index = -1;
        }
    }
    
    public String toString(){
        return symbol;
    }
}
