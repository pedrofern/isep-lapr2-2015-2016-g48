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
import lapr.project.ui.ucs.*;

/**
 *
 * @author Diana
 */
public class PainelRepresentante extends JPanel{

    private static JPanel pPrincipal;
    private static JPanel pInfo;
    private static Utilizador m_ut;
    private CentroExposicoes m_ce;
    
    private static final int LINHAS=5, COLUNAS=2,HGAP=20, VGAP=20;
    private static final Dimension DIM_BOTOES=new Dimension(150,35);
    private static final int TAM_LETRA_BOTAO=9;

    public PainelRepresentante(CentroExposicoes ce, Utilizador ut){
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
        
        pBotoes.add(criarBotaoCriarCand());
        pBotoes.add(criarBotaoAlterarCand());
        pBotoes.add(criarBotaoConfirmarStand());
        pBotoes.add(criarBotaoCandidaturaDemo());
        pBotoes.add(criarBotaoRemoverCand());
        
      
        return pBotoes;
    } 

    private JButton criarBotaoCriarCand(){
        JButton bt=new JButton("Registar candidatura");
        bt.setMnemonic(KeyEvent.VK_C);
        bt.setToolTipText("Registo de uma candidatura para uma exposição");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

               try{
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(PainelRepresentante.this, 
                           "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
               }


            }     
        }
            
        );
        
        return bt;
    }
    
    private JButton criarBotaoAlterarCand(){
        JButton bt=new JButton("Alterar candidatura");
        bt.setMnemonic(KeyEvent.VK_A);
        bt.setToolTipText("Alteração de candidatura");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {try{
                  AlterarCandidaturaUI a= new AlterarCandidaturaUI(m_ce, m_ut);
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(PainelRepresentante.this, 
                           "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
               }}   
        }
            
        );
        
        return bt;
    }
    
    
    private JButton criarBotaoConfirmarStand() {
        JButton bt=new JButton("Confirmar Stand");
        bt.setMnemonic(KeyEvent.VK_S);
        bt.setToolTipText("Confirmação de interesse a stand atribuído");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelRepresentante.this, 
                        "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }   
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoCandidaturaDemo() {
        JButton bt=new JButton("Submeter Candidatura a Demonstração");
        bt.setMnemonic(KeyEvent.VK_D);
        bt.setToolTipText("Sumissão de candidatura a Demonstração");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SubmeterCandidaturaDemoUI a= new SubmeterCandidaturaDemoUI(m_ce, m_ut);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(PainelRepresentante.this, 
                            "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
            
        );
        
        return bt;
    }

    

    private JButton criarBotaoRemoverCand() {
        
        JButton bt=new JButton("Remover Candidatura a Demonstração");
        bt.setMnemonic(KeyEvent.VK_D);
        bt.setToolTipText("Eliminação de candidatura a Demonstração");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelRepresentante.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }   
        }
            
        );
        
        return bt;
    }
}

