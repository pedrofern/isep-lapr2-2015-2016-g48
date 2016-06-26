package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lapr.project.model.CentroExposicoes;

/**
 *
 * @author Diana
 */
public class PainelInicio extends JPanel {

    private static CentroExposicoes m_ce;
    
    public PainelInicio(CentroExposicoes ce) {
        super();
        m_ce=ce;

        setLayout(new BorderLayout());
        
        criarComponentes();
    }
    
    private void criarComponentes(){
        
        PainelLogoAjustavel pImagem=new PainelLogoAjustavel();
        
        add(painelTexto(), BorderLayout.NORTH);
        add(pImagem, BorderLayout.CENTER);
    }
    
    private JPanel painelTexto(){
        JPanel p=new JPanel();
        
        JPanel pAcerca=new JPanel();  
        
        GridLayout gl=new GridLayout(1,3);
        gl.setHgap(20);
        
        pAcerca.setLayout(gl);
        JPanel pInfo1=new JPanel();
        JLabel info1=new JLabel("Nº Utilizadores: " + m_ce.getRegistoUtilizadores().getListaUtilizadores().size());
        pInfo1.add(info1);
        
        JPanel pInfo2=new JPanel();
        JLabel info2=new JLabel("Nº Exposiçoes: " + m_ce.getRegistoExposicoes().getExposicoes().size());
        pInfo1.add(info2);   

        pAcerca.add(pInfo1);
        pAcerca.add(pInfo2); 
        
        p.add(pAcerca);
        return p;
     }
        
}

