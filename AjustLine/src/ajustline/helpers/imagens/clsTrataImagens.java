package ajustline.helpers.imagens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;

public class clsTrataImagens {
    public ImageIcon getImageIcon(String path){
        URL imgURL = clsTrataImagens.class.getResource(path);
        if (imgURL != null){
            return new ImageIcon(imgURL);
        }
        else{
            return null;
        }
    }

    public Image getImage (String path) {
        URL imgURL = clsTrataImagens.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL).getImage();
        } else {
            return null;
        }
    }

    public Image createFDImage() {
        BufferedImage bi = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 15, 15);
        g.setColor(Color.RED);
        g.fillOval(5, 3, 6, 6);

        g.dispose();
        return bi;
    }
}