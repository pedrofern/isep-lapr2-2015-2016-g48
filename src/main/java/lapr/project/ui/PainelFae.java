package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.ui.ucs.AvaliarCandidaturaUI;

/**
 *
 * @author Diana
 */
public class PainelFae extends JPanel{

    private static JPanel pPrincipal;
    private static JPanel pInfo;
    private static Utilizador m_ut;
    private CentroExposicoes m_ce;
    
    private static final int LINHAS=2, COLUNAS=1,HGAP=20, VGAP=20;
    private static final Dimension DIM_BOTOES=new Dimension(150,35);
    private static final int TAM_LETRA_BOTAO=9;
    
    PainelFae(CentroExposicoes ce, Utilizador ut) {
        
        super();
        
        this.m_ce=ce;
        this.m_ut=ut;

        setLayout(new BorderLayout());
         
        criarPainelPrincipal(); 
        criarPainelInfo();

        add(pPrincipal, BorderLayout.WEST);
        add(pInfo, BorderLayout.CENTER); 
        
    }
    
    private void criarPainelPrincipal(){
         pPrincipal =new JPanel();
        pPrincipal.setLayout(new FlowLayout());
        pPrincipal.setBorder(new TitledBorder("Seleccione a opção: "));
        
        pPrincipal.add(criarPainelBotoes());
    }
    
     private void criarPainelInfo(){
        pInfo=new JPanel();
        pInfo.setLayout(new BorderLayout());

        PainelInicio p=new PainelInicio(m_ce);
        
        pInfo.add(p);         
    }
    
     private JPanel criarPainelBotoes(){

        JPanel pBotoes=new JPanel(); 
        GridLayout gl=new GridLayout(LINHAS,COLUNAS);
        
        pBotoes.setLayout(gl);
        //gl.setHgap(HGAP);
        gl.setVgap(VGAP);
        
        pBotoes.add(criarBotaoDefinirCand());
        pBotoes.add(criarBotaoAtualizarConflitos());

        return pBotoes;
    } 

   private JButton criarBotaoDefinirCand(){
        JButton bt=new JButton("Definir candidatura");
        bt.setMnemonic(KeyEvent.VK_D);
        bt.setToolTipText("Avaliação de uma candidatura");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                AvaliarCandidaturaUI a= new AvaliarCandidaturaUI(m_ce, m_ut);
            }
        });
        
               
        return bt;
    }
    
    private JButton criarBotaoAtualizarConflitos(){
        JButton bt=new JButton("Atualizar conflitos");
        bt.setMnemonic(KeyEvent.VK_A);
        bt.setToolTipText("Adicionar ou remover conflitos detectados (mecanismos)");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelFae.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }   
        }
            
        );
        
        return bt;
    }
}

