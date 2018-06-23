/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustline.helpers.types;

/**
 *
 * @author Rodolfo
 */
public class clsTrataConverterTypes {
    private clsTrataDatas mobjTrataDatas = new clsTrataDatas();
    private String objValor;
    
    //prepara um construtor padrao pois sempre recebe valor em String    
    public clsTrataConverterTypes(String objValor){
        this.objValor = objValor;
    }
    
    //converter String to Booleano
    public boolean ConvBooleano(){        
        if (objValor.toString().trim().equals("") || objValor.toString().trim().equals("0") || objValor.toString().trim().equals("false")){return false;} else {return true;}
    }
    
    //converter String to Double
    public double ConvDouble(){        
        if (objValor.toString().trim().equals("")){return 0;} else{return Double.parseDouble(objValor.toString());}        
    }

    //converter String to Float
    public float ConvFloat(){        
        if (objValor.toString().trim().equals("")){return 0;} else{return Float.parseFloat(objValor.toString());}        
    }

    //converter String to integer
    public int ConvInteger(){        
        if (objValor.toString().trim().equals("")){return 0;} else{return Integer.parseInt(objValor.toString());}
    }

    //converter String to integer
    public long ConvLong(){        
        if (objValor.toString().trim().equals("")){return 0;} else{return Long.parseLong(objValor.toString());}
    }

    //converter String to integer
    public short ConvShort(){        
        if (objValor.toString().trim().equals("")){return 0;} else{return Short.parseShort(objValor.toString());}
    }

    //converter String to DateTime
    public String ConvDateTime(){        
        if (objValor.toString().trim().equals("")){return "";} else{return mobjTrataDatas.parseDataIso(objValor.toString());}
    }

    //retorna String quando for String
    public String ConvString(){        
        return objValor.toString();
    }        
}
