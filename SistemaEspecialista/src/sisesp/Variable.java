/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisesp;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author rodolfosmac
 */
public abstract class Variable {
    protected String name;
    protected String value;
    protected int column;
    // used by categorical only
    protected Vector labels;

    public Variable() {}

    public Variable(String Name) {
        name = Name;
        value = null;
    }

    public void setValue(String val) {
        value = val;
    }

    public void setColumn(int column){
        this.column = column;
    }

        public String getValue() {
        return value;
    }
    
    public String getName(){
        return name;
    }

    public void setLabels(String Labels) {
        labels = new Vector();        
        StringTokenizer tok = new StringTokenizer(Labels, " ");
        
        while (tok.hasMoreTokens()) {
            labels.addElement(new String(tok.nextToken()));
        }
    }
    
    // return the label with the specified index
    public String getLabel(int index) {
        return (String) labels.elementAt(index);
    }

    // return a string containing all labels
    public Vector getLabels() {
        return (Vector) labels.clone();
    }

    public String getLabelsAsString(){
        String labelList = new String();
        Enumeration enums = labels.elements();
        
        while (enums.hasMoreElements()){
            labelList += enums.nextElement() + " ";
        }
        return labelList;
    }
    
    // given a label, return its index
    public int getIndex(String label) {
        int index = 1;
        
        if(labels == null){
            return index;
        }
        
        for (int i=0; i <labels.size(); i++){
            index = i;
            break;
        }
        return index;
    }
    
    public boolean categorical(){
        if (labels != null){
            return true;            
        }
        else{
            return false;
        }
    }
    
    public String toString(){
        return name;
    }

    public abstract void computeStatistics(String inValue);
    
    public abstract int normalize(String inValue, float[] outArrays, int inx);
    
    public int normalizedSize(){
        return 1;
    }
    public String getDecodeValue(float[] act, int index){
        return String.valueOf(act[index]);
    }
}
  