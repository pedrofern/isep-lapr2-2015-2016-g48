package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Diana
 */
public class PainelInicio extends JPanel {

    public PainelInicio() {
        super();

        setLayout(new BorderLayout());
        
        criarComponentes();
    }
    
    private void criarComponentes(){
        
        //PainelLogoAjustavel pImagem=new PainelLogoAjustavel();
        
        add(painelTexto(), BorderLayout.NORTH);
        //add(pImagem, BorderLayout.CENTER);
    }
    
    private JPanel painelTexto(){
 
        JPanel pAcerca=new JPanel();  
        pAcerca.setLayout(new GridLayout(3,1));
        
        JPanel pInfo1=new JPanel();
        JLabel info1=new JLabel("Nº utilizadores: ....");
        pInfo1.add(info1);
        
        JPanel pInfo2=new JPanel();
        JLabel info2=new JLabel("Nº exposiçoes: ....");
        pInfo1.add(info2);

        JPanel pInfo3=new JPanel();
        JLabel info3=new JLabel("Nº candidaturas: ....");
        pInfo1.add(info3);        
        
        pAcerca.add(pInfo1);
        pAcerca.add(pInfo2);
        pAcerca.add(pInfo2); 
        
        return pAcerca;
     }
        
}

