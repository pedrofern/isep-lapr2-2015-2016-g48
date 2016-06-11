package lapr.project.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Diana
 */

public class PainelLogoAjustavel extends JPanel{
    
    
    public PainelLogoAjustavel(){
        super();
 
    }

    @Override
    public void paintComponent(Graphics g) {
 
        
        
        try{
            super.paintComponent(g);
        
            Dimension dimensaoPainel = super.getSize(); 	              
            double largura = dimensaoPainel.getWidth();
            double altura = dimensaoPainel.getHeight();
            
            ImageIcon ICON = 
            new ImageIcon("src/main/resources/images/ce.png");
            
            Image img2 = ICON.getImage().getScaledInstance(
                (int) largura, 
                (int) altura, 
                Image.SCALE_SMOOTH);
        
            Image img3 = new ImageIcon(img2).getImage();

            g.drawImage(img3, 0, 0, this);
        
        }catch(Exception ex){
            System.out.println("Imagem não encontrada");
        } 
        
        
        
        
    }
}
