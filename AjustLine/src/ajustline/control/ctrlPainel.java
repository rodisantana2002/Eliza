/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustline.control;

import ajustline.helpers.actions.clsTrataActionsDinamicas;
import ajustline.helpers.types.clsConstants;
import ajustline.view.viewPainel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author rodolfosmac
 */
public class ctrlPainel implements ActionListener, KeyListener {
    private clsTrataActionsDinamicas mobjAction;
    private viewPainel viewPainel;
    private Thread capThread;
    private ctrlTextTransfer textTransfer;
    
    public ctrlPainel(){
        iniciarObjeto();        
    }

    public void carregarObjeto() {
        viewPainel.doShow();
    }
    
    public void iniciarCaptura(){
        viewPainel.iniciarCaptura();
        viewPainel.atualizarCiclos("0");
        viewPainel.habilitarRecursos(true);
                
        capThread = new Thread() {                
            public void run() {
                try {               
                    int ciclos=0;
                    while (true) {            
                        ciclos++;
                        sleep(5000);
                        viewPainel.atualizarCiclos(String.valueOf(ciclos));
                        String strTextToConvert = textTransfer.getClipboardContents();
                        
                        textTransfer.setClipboardContents(strTextToConvert.replaceAll("(\\r\\n)", ""));
                }                        

                } catch (InterruptedException ex) { }
            }
        };
        capThread.start();          
    }
    
    public void finalizarCaptura(){        
        capThread.suspend();
        viewPainel.habilitarRecursos(false);        
        viewPainel.pararCaptura();
    }

    private void iniciarObjeto(){
        viewPainel = new viewPainel();        
        viewPainel.configurarOuvinte(this);                        
        textTransfer = new ctrlTextTransfer();
    }
    
    public void finalizarObjeto(){
        viewPainel.quit();
    }    
           
    private void executarAction(Object Action){               
        mobjAction = new clsTrataActionsDinamicas(this, Action.toString());
        mobjAction.executarMetodoDinamico();
    } 
     
    @Override
    public void actionPerformed(ActionEvent e) {
        executarAction(e.getActionCommand());
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==clsConstants.KEY_ESC){
            finalizarObjeto();
        }
    }    
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}    

}
