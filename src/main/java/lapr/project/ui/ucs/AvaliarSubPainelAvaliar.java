package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import lapr.project.controller.AvaliarCandidaturaController;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.lists.ListaCandidaturas;

/**
 *
 * @author Diana
 */
public class AvaliarSubPainelAvaliar extends JPanel implements Serializable{
    
    private CentroExposicoes m_ce;
    private Exposicao m_exposicao;
    private JPanel painelQuestoes;
    private ListaCandidaturas m_listaCandidaturas;
    private Candidatura m_candidatura;
    private Avaliacao m_avaliacao;
    private AvaliarCandidaturaController m_controllerAC;
    
    private static final int LINHAS=5, COLUNAS=2;
    
    public AvaliarSubPainelAvaliar(AvaliarCandidaturaController controller){
        super();   
        m_controllerAC=controller;
    }   
        public void mostrarPainel(){
            setLayout(new BorderLayout());
            setBorder(new TitledBorder("Avaliacao")); 
            add(criarPainelAvaliacao());
            
        }
        
        public void setCand(Candidatura c){
            m_candidatura=c;
        }
        
        private JPanel criarPainelAvaliacao(){
            JPanel pQuestoes=new JPanel();
            pQuestoes.setLayout(new BorderLayout());
            
            painelQuestoes=new JPanel();
            GridLayout g1=new GridLayout(LINHAS, COLUNAS);
            painelQuestoes.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            painelQuestoes.setLayout(g1);
            
            m_candidatura=new Candidatura();
            
            m_controllerAC.setCandidatura(m_candidatura);
            
            m_controllerAC.criarAvaliacao();
            m_controllerAC.adicionarAvaliacao();
            m_controllerAC.criarQuestao();
            m_controllerAC.adicionarQuestao();

            criarQuestao1();
            criarQuestao2();
            criarQuestao3();
            criarQuestao4();
            criarQuestao5();
            
            pQuestoes.add(painelQuestoes);
            
            return pQuestoes;
        }

    private void criarQuestao1() {
        
        m_controllerAC.setPergunta1();
        JLabel q1=new JLabel(m_controllerAC.getPergunta());
        q1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q1);
        painelQuestoes.add(criarPainelRadioButtons());
    }
    
    private JPanel criarPainelRadioButtons(){
        
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        JRadioButton button1=new JRadioButton("1");
        JRadioButton button2=new JRadioButton("2");
        JRadioButton button3=new JRadioButton("3");
        JRadioButton button4=new JRadioButton("4");
        JRadioButton button5=new JRadioButton("5");
        
        ButtonGroup grupoBotoes=new ButtonGroup();
        grupoBotoes.add(button1);
        grupoBotoes.add(button2);
        grupoBotoes.add(button3);
        grupoBotoes.add(button4);
        grupoBotoes.add(button5);
        
        JPanel painelRadio=new JPanel();
        painelRadio.setLayout(new GridLayout(1,5));
        painelRadio.add(button1);
        painelRadio.add(button2);
        painelRadio.add(button3);
        painelRadio.add(button4);
        painelRadio.add(button5);
    
        painelRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        p.add(painelRadio);
        return p;
    }

    private void criarQuestao2() {
        
        m_controllerAC.setPergunta2();
        JLabel q2=new JLabel(m_controllerAC.getPergunta());
        q2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q2);
        painelQuestoes.add(criarPainelRadioButtons());
    }

    private void criarQuestao3() {
        
        m_controllerAC.setPergunta3();
        JLabel q3=new JLabel(m_controllerAC.getPergunta());
        q3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q3);
        painelQuestoes.add(criarPainelRadioButtons());
        
    }

    private void criarQuestao4() {
        
        m_controllerAC.setPergunta4();
        JLabel q4=new JLabel(m_controllerAC.getPergunta());
        q4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q4);
        painelQuestoes.add(criarPainelRadioButtons());
    }

    private void criarQuestao5() {
        
        m_controllerAC.setPergunta5();
        JLabel q5=new JLabel(m_controllerAC.getPergunta());
        q5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q5);
        painelQuestoes.add(criarPainelRadioButtons());
    }
        
        
        
        
    }

