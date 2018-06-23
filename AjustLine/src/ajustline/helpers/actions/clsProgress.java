package ajustline.helpers.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class clsProgress extends JDialog {
    
    public clsProgress(int posX, int posY){
        iniciarComponentes(posX, posY);
    }
    
    public void doShow(){
        setVisible(true);
    }
 
    public void quit() {
       dispose();
    }
    
    private void iniciarComponentes(int posX, int posY){    
        int intInsetX = posX;
        int intInsetY = posY+100;
        int intLargura = 350;
        int intAltura = 250;   
        
        setBounds(intInsetX, intInsetY, intLargura, intAltura);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setModalityType(ModalityType.MODELESS);
        setTitle("rsTOOLS");
        getContentPane().add(criarPainelCentral(), BorderLayout.CENTER);
    }

    private JComponent criarPainelCentral() {
        JPanel paneCenter = new JPanel(new BorderLayout());
        paneCenter.setBackground(Color.WHITE);
        paneCenter.setBorder(null);
        JLabel lblImagem = new JLabel(new ImageIcon("Imagens/aguarde4.gif"));
        paneCenter.add(lblImagem, BorderLayout.CENTER);
        return paneCenter;
    }
}
