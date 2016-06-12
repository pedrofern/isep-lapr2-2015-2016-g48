
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import lapr.project.controller.AvaliarCandidaturaController;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;

/**
 *
 * @author DIana
 */
public class AvaliarSubPainelJustificacao extends JPanel implements Serializable{
    
    private Candidatura candidatura;
    private Avaliacao avaliacao;
    private AvaliarCandidaturaController controllerAC;
    
    private final int CAMPO_LARGURA = 30;
    private JTextArea txt;
    
    public AvaliarSubPainelJustificacao (AvaliarCandidaturaController pController){
        super();
        
        controllerAC=pController;
    }
    
    public void mostrarPainel(){
        setLayout(new BorderLayout());
        
        add(criarPainelAvaliacao());
    }
    
    public void setCand(Candidatura c){
        candidatura=c;
    }

    private JPanel criarPainelAvaliacao() {
        JPanel pAvaliacao=new JPanel();
        pAvaliacao.setLayout(new BorderLayout());
        
        pAvaliacao.add(criarPainelJustificacao(), BorderLayout.CENTER);
        pAvaliacao.add(criarPainelDecisao(), BorderLayout.SOUTH);
 
        return pAvaliacao;   
            
    }

    private JPanel criarPainelJustificacao() {
        JPanel pJustificacao=new JPanel();
        pJustificacao.setLayout(new BorderLayout());
        pJustificacao.setBorder(new TitledBorder("Justificação")); 
        
        txt= new JTextArea();
        txt.setPreferredSize(new Dimension(240, 100));

        pJustificacao.add(txt, BorderLayout.CENTER);
        
        return pJustificacao;
    }

    private JPanel criarPainelDecisao() {
       JPanel pDecisao=new JPanel();
        pDecisao.setLayout(new BorderLayout());
        pDecisao.setBorder(new TitledBorder("Avaliação")); 
        
        pDecisao.add(criarPainelRadioButtons());
        
        return pDecisao;
    }
    
    private JPanel criarPainelRadioButtons(){
        
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        JRadioButton button1=new JRadioButton("Aceite");
        JRadioButton button2=new JRadioButton("Recusada");
        
        ButtonGroup grupoBotoes=new ButtonGroup();
        grupoBotoes.add(button1);
        grupoBotoes.add(button2);
        
        JPanel painelRadio=new JPanel();
        painelRadio.setLayout(new GridLayout(1,2));
        painelRadio.add(button1);
        painelRadio.add(button2);
     
        p.add(painelRadio);
        return p;
    }
}
