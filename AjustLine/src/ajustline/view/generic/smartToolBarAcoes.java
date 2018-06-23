/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustline.view.generic;

import ajustline.helpers.types.clsConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
/**
 *
 * @author Rodolfo
 */
public class smartToolBarAcoes {
    private JToolBar tooBar;
    private JButton cmdIniciar, cmdParar, cmdSair;
       
    public smartToolBarAcoes(){}
    
    public JToolBar getBarraCommands(){
        tooBar = new JToolBar();
        tooBar.setFloatable(false);
        tooBar.setOpaque(true);
        tooBar.setBorderPainted(false);
        criarCommands();      
        tooBar.add(cmdIniciar);        
        tooBar.add(cmdParar);        
        tooBar.add(cmdSair);
        return tooBar;
    }
    
    private void criarCommands() {       
        cmdIniciar = new JButton(new ImageIcon("Imagens/player.png"));
        cmdIniciar.setActionCommand(clsConstants.METODO_NAME_INICIAR_CAPTURA);                            
        cmdIniciar.setToolTipText("Inicia o processo de captura de dados da área de tranferência");        
        cmdIniciar.setFocusable(false);
        
        cmdParar = new JButton(new ImageIcon("Imagens/pause.gif"));
        cmdParar.setActionCommand(clsConstants.METODO_NAME_TERMINAR_CAPTURA);                            
        cmdParar.setToolTipText("Termina o processo de captura de dados da área de tranferência");        
        cmdParar.setFocusable(false);                        
        cmdParar.setEnabled(false);
        
        cmdSair = new JButton(new ImageIcon("Imagens/Cancel.png"));
        cmdSair.setActionCommand(clsConstants.METODO_NAME_SAIR);                            
        cmdSair.setToolTipText("Finaliza o programa");        
        cmdSair.setMnemonic(KeyEvent.VK_ESCAPE);
        cmdSair.setFocusable(false);                        
        cmdSair.setEnabled(true);        
    }
   
    public void setRecursos(boolean status){        
        if (status){            
            cmdParar.setEnabled(true);
            cmdIniciar.setEnabled(false);
        }    
        else{
            cmdParar.setEnabled(false);
            cmdIniciar.setEnabled(true);
        }
    }         
    
    public void configurarOuvinte(ActionListener ouvinte){
        cmdIniciar.addActionListener(ouvinte);
        cmdParar.addActionListener(ouvinte);
        cmdSair.addActionListener(ouvinte);
        cmdSair.addKeyListener((KeyListener) ouvinte);
    }
}