/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustline.view;

import ajustline.view.generic.smartToolBarAcoes;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author rodolfosmac
 */
public class viewPainel extends JFrame{
    private smartToolBarAcoes barAcoes;
    private JLabel lblStattus, lblCiclos;
    private String strCiclos = "00"; 
    
    public viewPainel(){
        initComponentes();
    }
   
    public void doShow(){
        setVisible(true);
    }
        
    private void initComponentes(){    
        int intInsetX = 50;
        int intInsetY = 30;
        int intLargura = 300;
        int intAltura = 90;  
        
        setBounds(intInsetX, intInsetY, intLargura, intAltura);        
        ImageIcon img = new ImageIcon("imagens/start.png");       
        setIconImage(img.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().add(criarPainelCentral());
        setTitle("rsTOOLS - AjustLine");
    }
       
    private JComponent criarPainelCentral(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(criarPainelSuperior(), BorderLayout.CENTER);
        panel.add(criarPainelAcoes(), BorderLayout.SOUTH);
        barAcoes.setRecursos(false);
        return panel;
    }
    
    public void mouseWork(boolean blnStatus){
        if (blnStatus){
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
        else {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
        
    public void configurarOuvinte(ActionListener ouvinte){
        barAcoes.configurarOuvinte(ouvinte);
    }
    
    public void pararCaptura(){
        lblStattus.setText("Em Pausa");              
        lblStattus.setIcon(new ImageIcon("imagens/rb.gif"));                
    }
    
    public void iniciarCaptura(){
        lblStattus.setText("Capturando dados");        
        lblStattus.setIcon(new ImageIcon("imagens/rbs.gif"));        
    }
    
    public void habilitarRecursos(boolean status){
        barAcoes.setRecursos(status);        
    }
    
    public void atualizarCiclos(String ciclos){
        lblCiclos.setText(ciclos);
    }
    
    public void quit() {
       System.exit(0);
    }    

    private JComponent criarPainelSuperior() {
        JPanel panel = new JPanel(new GridLayout(1, 2));        
        panel.add(criarPainelStatus());
        panel.add(criarPainelTempo());    
        return panel;
    }
    
    private JComponent criarPainelStatus() {
        JPanel panel = new JPanel(new BorderLayout());        
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Status", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 11)));
        panel.add(criarLabelStatus());        
        return panel;
    }
       
    private JComponent criarLabelStatus(){
        lblStattus = new JLabel("Em Pausa", new ImageIcon("imagens/rb.gif"), JLabel.LEFT);
        lblStattus.setFont(new Font("Arial", Font.PLAIN, 12));        
        return lblStattus;
    }
    
    private JComponent criarLableCiclos(){
        lblCiclos = new JLabel(strCiclos, JLabel.CENTER);
        return lblCiclos;
    }
    
    private JComponent criarPainelTempo() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Ciclos", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 11)));
        panel.add(criarLableCiclos());
        return panel;
    }
    
    private JComponent criarPainelAcoes() {
        JPanel panel = new JPanel(new BorderLayout());         
        panel.add(criarBarraAcoes(), BorderLayout.EAST);        
        return panel;
    }
    
    private JComponent criarBarraAcoes() {
        barAcoes = new smartToolBarAcoes();                
        return barAcoes.getBarraCommands();
    }
}
