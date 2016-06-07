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
import lapr.project.ui.ucs.AtribuirCandidaturaUI;

/**
 *
 * @author Diana
 */
public class PainelOrganizador extends JPanel {
 
    private static JPanel pPrincipal;
    private static JPanel pInfo;
    private static String m_ut;
    private CentroExposicoes m_ce;

    private static final int LINHAS=5, COLUNAS=2,HGAP=20, VGAP=20;
    private static final Dimension DIM_BOTOES=new Dimension(200,35);
    private static final int TAM_LETRA_BOTAO=9;

    PainelOrganizador(CentroExposicoes ce, String ut) {
        super();
        
        this.m_ce=ce;
        this.m_ut=ut;

        setLayout(new BorderLayout());
 
        criarPainelPrincipal();

        
        add(pPrincipal, BorderLayout.CENTER);

    }

    private void criarPainelPrincipal(){
        pPrincipal =new JPanel();
        pPrincipal.setLayout(new FlowLayout());
        pPrincipal.setBorder(new TitledBorder("Seleccione a opção: "));
        
        pPrincipal.add(criarPainelBotoes());
    }

     private JPanel criarPainelBotoes(){
        JPanel pBotoes=new JPanel(); 
        GridLayout gl=new GridLayout(LINHAS,COLUNAS);
        
        pBotoes.setLayout(gl);
        gl.setHgap(HGAP);
        gl.setVgap(VGAP);
        
        pBotoes.add(criarBotaoDefFae());
        pBotoes.add(criarBotaoAtribCand());
        pBotoes.add(criarBotaoCriarDemo());
        pBotoes.add(criarBotaoDecidirCand());
        pBotoes.add(criarBotaoAtribuirStand());
        pBotoes.add(criarBotaoDefinirDemo());
        pBotoes.add(criarBotaoListarCandRemovidas());
        pBotoes.add(criarBotaoAlterarDemo());
        pBotoes.add(criarBotaoRemoverDemo());

        return pBotoes;
    } 

    private JButton criarBotaoDefFae(){
        JButton bt=new JButton("Definir FAE");
        bt.setMnemonic(KeyEvent.VK_F);
        bt.setToolTipText("Atribuição de FAE a uma exposição");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }
    
    private JButton criarBotaoAtribCand(){
        JButton bt=new JButton("Atribuir Candidatura");
        bt.setMnemonic(KeyEvent.VK_A);
        bt.setToolTipText("Atribuição de candidaturas a FAE´s");
        bt.setPreferredSize(DIM_BOTOES);
        
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtribuirCandidaturaUI();     
            }
            
        }
           
        );
        
        
        return bt;
    }
    
    private JButton criarBotaoCriarDemo(){
        JButton bt=new JButton("Criar Demonstração");
        bt.setMnemonic(KeyEvent.VK_C);
        bt.setToolTipText("Criação de demonstrações numa exposição");
        bt.setPreferredSize(DIM_BOTOES);
        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            }
            
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoDecidirCand() {
        
        JButton bt=new JButton("Decidir Candidatura");
        bt.setMnemonic(KeyEvent.VK_D);
        bt.setToolTipText("Processo de decisão de candidatura (aceite ou recusada)");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoAtribuirStand() {
        JButton bt=new JButton("Atribuir Stand");
        bt.setMnemonic(KeyEvent.VK_S);
        bt.setToolTipText("Atribuição de stand a uma candidatura");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoDefinirDemo() {
        JButton bt=new JButton("Definir Demonstração");
        bt.setMnemonic(KeyEvent.VK_D);
        bt.setToolTipText("Confirmação da demonstração e definição do seu período de submissão");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoListarCandRemovidas() {
        JButton bt=new JButton("Candidaturas Removidas");
        bt.setMnemonic(KeyEvent.VK_R);
        bt.setToolTipText("Listagem de Candidaturas Removidas");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoAlterarDemo() {
        JButton bt=new JButton("Alterar Demonstração");
        bt.setMnemonic(KeyEvent.VK_A);
        bt.setToolTipText("Alteração dos dados de demonstração");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }

    private JButton criarBotaoRemoverDemo() {
        JButton bt=new JButton("Eliminar Demonstração");
        bt.setMnemonic(KeyEvent.VK_E);
        bt.setToolTipText("Remoção de uma demonstração");
        bt.setPreferredSize(DIM_BOTOES);

        bt.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(PainelOrganizador.this, "Em construção", "Aviso", JOptionPane.WARNING_MESSAGE);
            }     
        }
            
        );
        
        return bt;
    }
    
}

