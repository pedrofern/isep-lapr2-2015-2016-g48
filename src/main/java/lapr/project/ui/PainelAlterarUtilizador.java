package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Diana
 */
public class PainelAlterarUtilizador extends JPanel{
    
    public PainelAlterarUtilizador(){
        
        super();
        
        setLayout(new BorderLayout());
        criarComponentes();
    }
    
    private void criarComponentes(){
        JPanel p=new JPanel();
        
        p.setLayout(new FlowLayout());
        
        add(p);
    }   
    
}
