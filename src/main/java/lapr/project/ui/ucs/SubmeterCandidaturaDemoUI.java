package lapr.project.ui.ucs;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import lapr.project.controller.RegistarUtilizadorController;
import lapr.project.model.CentroExposicoes;

/**
 *
 * @author Diana
 */
public class SubmeterCandidaturaDemoUI extends JFrame {
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 650;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 275;
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Username: ").getPreferredSize();
    
    private CentroExposicoes centroDeExposicoes;
    
    //private SubmeterCandidaturaController m_controllerSCD;
   
    public SubmeterCandidaturaDemoUI(CentroExposicoes ce){
        super("Submeter Candidatura a Demonstracao");
        
        centroDeExposicoes=ce;
        
        
    }
}
