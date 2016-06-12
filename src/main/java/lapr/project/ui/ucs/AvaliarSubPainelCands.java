package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import lapr.project.controller.AvaliarCandidaturaController;
import lapr.project.model.Candidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.lists.ListaCandidaturas;

/**
 *
 * @author Diana
 */
public class AvaliarSubPainelCands extends JPanel implements Serializable{
    
    private Exposicao exposicao;
    private ListaCandidaturas lista;
    private Candidatura candidatura;
    private JComboBox comboCands;
    private JButton selCand;
    private static final int WIDTH_POR_OMISSAO=300;
    private AvaliarCandidaturaController controllerAC;
    
    public AvaliarSubPainelCands(AvaliarCandidaturaController controller){
        super();
        controllerAC=controller;
        
    }
    
    public void mostrarPainel(){
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Seleccione a candidatura"));
        add(criarPainelCands());
    }

    private JPanel criarPainelCands() {
        JPanel p=new JPanel();
        p.setLayout(new FlowLayout());
        
        String[] opcoes={"whiskas", "friskies"};
        comboCands=new JComboBox(opcoes);
        
        p.add(comboCands, BorderLayout.NORTH);
        p.add(criarBtSelect());
        
        return p;
    }
    
    public void setExpo(Exposicao e){
        exposicao=e;
    }

    private JButton criarBtSelect() {
        selCand=new JButton("Seleccionar");
        
        selCand.setMnemonic(KeyEvent.VK_S);
        selCand.setToolTipText("Selecionar candidatura da lista");
        
        selCand.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                //nao esquecer try... candidatura adicionada e avaliacao criada
                //m_candidatura=(Candidatura) comboCands.getSelectedItem();
                
                candidatura=new Candidatura();
                AvaliarSubPainelAvaliar painel=AvaliarCandidaturaUI.getPainelAvaliar();
                
                painel.mostrarPainel();
      
                selCand.setEnabled(false);
                painel.setVisible(true);
                
            }     
        }
        );
        
        return selCand;
    }
    
}
