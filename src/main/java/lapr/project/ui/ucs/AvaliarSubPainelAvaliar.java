package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import lapr.project.controller.AvaliarCandidaturaController;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;
import lapr.project.model.lists.ListaCandidaturas;

/**
 *
 * @author Diana
 */
public class AvaliarSubPainelAvaliar extends JPanel implements Serializable{

    private JPanel painelQuestoes, pQuestoes;
    private ListaCandidaturas m_listaCandidaturas;
    private Candidatura m_candidatura;
    private Avaliacao m_avaliacao;
    private AvaliarCandidaturaController m_controllerAC;
    private int resposta;
    
    AvaliarCandidaturaRadioButton grupo1, grupo2, grupo3, grupo4, grupo5;
            
    private static final int LINHAS=5, COLUNAS=2;
    
    public AvaliarSubPainelAvaliar(AvaliarCandidaturaController controller){
        super();   
        m_controllerAC=controller;
        
        setPreferredSize(new Dimension(800,getHeight()));
    }   
        public void mostrarPainel(){
            setLayout(new BorderLayout());
            setBorder(new TitledBorder("Classificação")); 
            add(criarPainelJustificacao());
            
        }
        
        public void setCand(Candidatura c){
            m_candidatura=c;
        }
        
        private JPanel criarPainelJustificacao(){
            pQuestoes=new JPanel();
            pQuestoes.setLayout(new BorderLayout());
            
            painelQuestoes=new JPanel();
            GridLayout g1=new GridLayout(LINHAS, COLUNAS);
            painelQuestoes.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            painelQuestoes.setLayout(g1);
            
            
            //alterar qd ja houver candidatura seleccionada ( nao ha candidaturas no registo)
            m_candidatura=new Candidatura();
            
            m_controllerAC.setCandidatura(m_candidatura);
            
            m_controllerAC.criarAvaliacao();
            m_controllerAC.adicionarAvaliacao();
            
            criarQuestao1();
            criarQuestao2();
            criarQuestao3();
            criarQuestao4();
            criarQuestao5();
            
            pQuestoes.add(painelQuestoes, BorderLayout.CENTER);
            pQuestoes.add(criarBotaoContinuar(), BorderLayout.SOUTH);
            
            return pQuestoes;
        }

    private void criarQuestao1() {
        m_controllerAC.criarQuestao();
        m_controllerAC.adicionarQuestao();
        
        m_controllerAC.setPergunta1();
        JLabel q1=new JLabel(m_controllerAC.getPergunta());
        q1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q1);
        
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        grupo1=new AvaliarCandidaturaRadioButton();
        
        JPanel painelRadio=new JPanel();
        
        painelRadio.setLayout(new GridLayout(1,5));
        painelRadio.add(grupo1.getButton1());
        painelRadio.add(grupo1.getButton2());
        painelRadio.add(grupo1.getButton3());
        painelRadio.add(grupo1.getButton4());
        painelRadio.add(grupo1.getButton5());
      
        painelRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        p.add(painelRadio);
        
        painelQuestoes.add(p);
        
    }
  

    private void criarQuestao2() {
        m_controllerAC.criarQuestao();
        m_controllerAC.adicionarQuestao();
        
        m_controllerAC.setPergunta2();
        JLabel q2=new JLabel(m_controllerAC.getPergunta());
        q2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q2);
        
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        grupo2=new AvaliarCandidaturaRadioButton();
        JPanel painelRadio=new JPanel();
        
        painelRadio.setLayout(new GridLayout(1,5));
        painelRadio.add(grupo2.getButton1());
        painelRadio.add(grupo2.getButton2());
        painelRadio.add(grupo2.getButton3());
        painelRadio.add(grupo2.getButton4());
        painelRadio.add(grupo2.getButton5());
      
        painelRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        p.add(painelRadio);
        
        painelQuestoes.add(p);
        
       
    }

    private void criarQuestao3() {
        m_controllerAC.criarQuestao();
        m_controllerAC.adicionarQuestao();
        
        m_controllerAC.setPergunta3();
        JLabel q3=new JLabel(m_controllerAC.getPergunta());
        q3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q3);
        
       JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        grupo3=new AvaliarCandidaturaRadioButton();
        JPanel painelRadio=new JPanel();
        
        painelRadio.setLayout(new GridLayout(1,5));
        painelRadio.add(grupo3.getButton1());
        painelRadio.add(grupo3.getButton2());
        painelRadio.add(grupo3.getButton3());
        painelRadio.add(grupo3.getButton4());
        painelRadio.add(grupo3.getButton5());
      
        painelRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        p.add(painelRadio);
        
        painelQuestoes.add(p);
        
    }

    private void criarQuestao4() {
        m_controllerAC.criarQuestao();
        m_controllerAC.adicionarQuestao();
        
        m_controllerAC.setPergunta4();
        JLabel q4=new JLabel(m_controllerAC.getPergunta());
        q4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q4);
      
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        grupo4=new AvaliarCandidaturaRadioButton();
        JPanel painelRadio=new JPanel();
        
        painelRadio.setLayout(new GridLayout(1,5));
        painelRadio.add(grupo4.getButton1());
        painelRadio.add(grupo4.getButton2());
        painelRadio.add(grupo4.getButton3());
        painelRadio.add(grupo4.getButton4());
        painelRadio.add(grupo4.getButton5());
      
        painelRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        p.add(painelRadio);
        
        painelQuestoes.add(p);
        
    }

    private void criarQuestao5() {
        m_controllerAC.criarQuestao();
        m_controllerAC.adicionarQuestao();
        
        m_controllerAC.setPergunta5();
        JLabel q5=new JLabel(m_controllerAC.getPergunta());
        q5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        painelQuestoes.add(q5);
        
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        grupo5=new AvaliarCandidaturaRadioButton();
        JPanel painelRadio=new JPanel();
        
        painelRadio.setLayout(new GridLayout(1,5));
        painelRadio.add(grupo5.getButton1());
        painelRadio.add(grupo5.getButton2());
        painelRadio.add(grupo5.getButton3());
        painelRadio.add(grupo5.getButton4());
        painelRadio.add(grupo5.getButton5());
      
        painelRadio.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY));
        
        p.add(painelRadio);
        
        painelQuestoes.add(p);
        
    }
    
    private JPanel criarBotaoContinuar() {
        
        JPanel p=new JPanel();
        JButton btContinuar=new JButton("Continuar");
        
        btContinuar.setMnemonic(KeyEvent.VK_S);
        btContinuar.setSize(20, getHeight());
      
        
        btContinuar.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                //nao esquecer try... candidatura adicionada e avaliacao criada
                //m_candidatura=(Candidatura) comboCands.getSelectedItem();
                
                List<AvaliarCandidaturaRadioButton> lista=new ArrayList<AvaliarCandidaturaRadioButton>();
                lista.add(grupo1);
                lista.add(grupo2);
                lista.add(grupo3);
                lista.add(grupo4);
                lista.add(grupo5);
                
                List<Integer> resposta=new ArrayList<Integer>();
            
                for (AvaliarCandidaturaRadioButton grupo: lista){                  
              
                        int resp=0;
                        if (grupo.getButton1().isSelected())
                            resp=1;
                        if (grupo.getButton2().isSelected())
                            resp=2;
                        if (grupo.getButton3().isSelected())
                            resp=3;
                        if (grupo.getButton4().isSelected())
                            resp=4;
                        if (grupo.getButton5().isSelected())
                            resp=5;
                        
                        resposta.add(resp);                    

                }

//                TESTE RESPOSTAS
//                for (int r: resposta){
//
//                    System.out.println(r);
//                }

                m_controllerAC.setRespostas(resposta.get(0), resposta.get(1), resposta.get(2), resposta.get(3), resposta.get(4));
                
                JOptionPane.showMessageDialog(
                            null,
                            m_controllerAC.getInfoClassificacoes(),
                            "Classificações dadas",
                            JOptionPane.INFORMATION_MESSAGE);
                
                
                AvaliarSubPainelJustificacao pJustificacao=new AvaliarSubPainelJustificacao(m_controllerAC);

                
                pJustificacao.mostrarPainel();
                pQuestoes.setVisible(false);

                add(pJustificacao);
                AvaliarCandidaturaUI.ativarGuardar();
            }
        });
        
        
        p.add(btContinuar);
        
        return p;
    }
        
        
        
        
}