package lapr.project.ui.ucs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.*;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.Utils;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarUtilizadorUI extends JFrame{
    
     /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 650;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 275; 
    
    private CentroExposicoes m_ce;
    
    private String pergunta="Pretende cancelar o registo do utilizador?";
      
    private RegistarUtilizadorController m_controllerRU;
    
    private PainelDadosUtilizador norte;
    
    public RegistarUtilizadorUI(CentroExposicoes ce) {
        
        super("Registar Utilizador");
 
        m_ce = ce;
        m_controllerRU = new RegistarUtilizadorController(m_ce);
 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanelaRegistoUtilizador("Pretende voltar ao menu principal?");
            }
        });
        
        add(criarPainel());
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setLocationRelativeTo(null);
        setVisible(true);          
    }
    
    private JPanel criarPainel(){
        JPanel p =new JPanel();
        p.setLayout(new BorderLayout());
        norte = new PainelDadosUtilizador();
        JPanel botoes = criarPainelBotoes();  
        
        p.add(norte, BorderLayout.NORTH);
        p.add(botoes, BorderLayout.SOUTH);
        
        return p;
    }
    
    /**
     * cria painel botões
     * @return painel botões
     */
    private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);

        JButton bt1 = criarBotaoRegistar();
        JButton bt2 = criarBotaoLimpar();
        JButton bt3 = criarBotaoCancelar();
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
    }
    
    private JButton criarBotaoRegistar() {
        JButton botao = new JButton("Registar Utilizador");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Registar Utilizador");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(norte.getTxtNome().getText().isEmpty()==true||
                    norte.getTxtEmail().getText().isEmpty()==true||
                    norte.getTxtPassword().getText().isEmpty()==true||
                    norte.getTxtUsername().getText().isEmpty()==true){
                        JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Registar Utilizador",
                            JOptionPane.ERROR_MESSAGE);                        
                }else{
                    guardar();
                }
            }
        });

        return botao;
    }
    /**
     * criar botão limpar
     * @return botão limpar
     */
    private JButton criarBotaoLimpar() {
        JButton botao = new JButton("Limpar");
        botao.setMnemonic(KeyEvent.VK_L);
        botao.setToolTipText("Limpa dados gerais do novo utilizador");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                norte.getTxtNome().setText("");
                norte.getTxtEmail().setText("");
                norte.getTxtPassword().setText("");
                norte.getTxtUsername().setText("");
            }
        });

        return botao;
    }
    
    /**
     * criar botão cancelar e volta menu anterior
     * @return botão cancelar e volta menu anterior 
     */
    private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela o registo de utilizador e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanelaRegistoUtilizador(pergunta);
            }
        });

        return botao;
    }
    
     private void guardar() {
            String nome,email,pass,user;
            nome = norte.getTxtNome().getText();
            email = norte.getTxtEmail().getText();
            pass = norte.getTxtPassword().getText();
            user = norte.getTxtUsername().getText();
            m_controllerRU.novoUtilizador();

            m_controllerRU.criaUtilizador(nome, email, user, pass);
                JOptionPane.showMessageDialog(
                            null,
                            "Dados novo utilizador registado: \n"
                                    +"\nUsername: "+user
                                    +"\nPassword: "+pass
                                    +"\nNome: "+nome
                                    +"\nEmail: "+email,
                            "Registar Utilizador",
                            JOptionPane.INFORMATION_MESSAGE);    
            dispose();
    }
     
    private void fecharJanelaRegistoUtilizador(String pergunta){
        if (norte.getTxtNome().getText()!=""||
                norte.getTxtEmail().getText()!=""||
                norte.getTxtPassword().getText()!=""||
                norte.getTxtUsername().getText()!=""){
            String[] opcoes = {"Sim", "Não"};
            
            int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                    "Registar utilizador", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (opcao == JOptionPane.YES_OPTION) {                        
                dispose();
            } else {
                 setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                       
            }
        }
    }

}
