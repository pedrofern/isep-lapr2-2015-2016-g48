package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import lapr.project.controller.AlterarUtilizadorController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.utils.Utils;

/**
 *
 * @author Diana
 */
public class AlterarUtilizadorUI extends RegistarUtilizadorUI{
    private CentroExposicoes m_centroDeExposicoes;
    private String m_utilizador;
    private AlterarUtilizadorController m_controller;

    public AlterarUtilizadorUI(CentroExposicoes centroDeExposicoes, String ut){
        super(centroDeExposicoes);
        
        this.setTitle("Alterar Utilizador");
        String pergunta="Pretende cancelar a alteração do registo de utilizador?";
        
        this.setPergunta(pergunta);
 
        this.removerEmailPainelNorte();
        
        
    }
}