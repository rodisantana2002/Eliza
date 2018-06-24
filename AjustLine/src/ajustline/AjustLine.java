/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustline;

import ajustline.control.ctrlPainel;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author rodolfosmac
 */
public class AjustLine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //define um padrao de visualizacao para a aplicacao    
        UIManager.put("control", new Color(232, 232, 232));
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().toUpperCase().equals("NIMBUS")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception ex) {ex.printStackTrace();}
            }
        }   
        ctrlPainel painel = new ctrlPainel();
        painel.carregarObjeto();

    }
    
}
