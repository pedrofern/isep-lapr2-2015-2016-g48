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
import lapr.project.ui.ucs.CriarStandUI;

/**
 *
 * @author Diana
 */
public class PainelGestor extends JPanel {

    private static JPanel pPrincipal;
    private static JPanel pInfo;
    private static Utilizador m_ut;
    private CentroExposicoes m_ce;
    
    private static final int LINHAS=5, COLUNAS=2,HGAP=20, VGAP=20;
    private static final Dimension DIM_BOTOES=new Dimension(150,35);
    private static final int TAM_LETRA_BOTAO=9;
    
    public PainelGestor(CentroExposicoes ce, Utilizador ut) {
        
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

        PainelInicio p=new PainelInicio();
        
        pInfo.add(p);  
    }
    
     private JPanel criarPainelBotoes(){

        JPanel pBotoes=new JPanel(); 

        GridLayout gl=new GridLayout(LINHAS,COLUNAS);
        
        pBotoes.setLayout(gl);
        gl.setVgap(VGAP);
        
        pBotoes.add(criarBotaoCriarExpo());
        pBotoes.add(criarBotaoConfirmarUtilizador());
        pBotoes.add(criarBotaoDefinirRecurso());
        pBotoes.add(criarBotaoDefinirConlito());
        pBotoes.add(criarBotaoCriarStand());
        
      
        return pBotoes;
    } 

    private JButton criarBotaoCriarExpo() {
        JButton bt=new JButton("Criar exposição");
        bt.setMnemonic(KeyEvent.VK_E);
        bt.setToolTipText("Criação de uma exposição e definição dos organizadores");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelGestor.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoConfirmarUtilizador() {
        JButton bt=new JButton("Confirmar Utilizador");
        bt.setMnemonic(KeyEvent.VK_C);
        bt.setToolTipText("Confirmação de registo de utilizador");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(PainelGestor.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoDefinirRecurso() {
        JButton bt=new JButton("Definir Recurso");
        bt.setMnemonic(KeyEvent.VK_R);
        bt.setToolTipText("Criação de recursos no centro de exposições");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelGestor.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoDefinirConlito() {
        JButton bt=new JButton("Definir Conflito");
        bt.setMnemonic(KeyEvent.VK_C);
        bt.setToolTipText("Definição de Tipos de Conflito");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelGestor.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoCriarStand() {
        JButton bt=new JButton("Criar Stand");
        bt.setMnemonic(KeyEvent.VK_S);
        bt.setToolTipText("Criação de stands no centro de exposições");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(PainelGestor.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                  new CriarStandUI();
            }     
        }
            
        );
        
        return bt;
    }
    
    
    
    
    
}
