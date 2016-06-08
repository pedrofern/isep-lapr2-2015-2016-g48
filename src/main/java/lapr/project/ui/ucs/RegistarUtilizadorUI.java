package lapr.project.ui.ucs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.*;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.ui.Login;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarUtilizadorUI extends JFrame{
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 600;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 275;
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Username: ").
                                                        getPreferredSize();
    /**
     * Guarda o nome introduzido da candidatura
     */
    private JTextField txtNome;
    /**
     * Guarda a morada introduzida da candidatura
     */
    private JTextField txtEmail;
    /**
     * Guarda o telemovel introduzido da candidatura
     */
    private JTextField txtUsername;
    /**
     * Guarda a area introduzida da candidatura
     */
    private JPasswordField txtPassword;
    private String strErro;
    private CentroExposicoes centroDeExposicoes;
    private RegistarUtilizadorController m_controllerRU;

    public RegistarUtilizadorUI(CentroExposicoes ce) {
        
        super("Registar Utilizador");

    
        centroDeExposicoes = ce;
        m_controllerRU = new RegistarUtilizadorController(centroDeExposicoes);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanelaRegistoUtilizador();
            }
        });
        
        JPanel norte = criarPainelDadosUtilizador();
        JPanel botoes = criarPainelBotoes();        
        
        add(norte, BorderLayout.NORTH);
        add(botoes, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));

        setVisible(true);          
    }
    
    private JPanel criarPainelDadosUtilizador(){
        JPanel painelNorte = new JPanel( new GridLayout(4,1));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 25, MARGEM_DIREITA = 0;
        painelNorte.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Dados Utilizador"),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        txtNome = new JTextField(40);
        txtNome.requestFocusInWindow();
        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtNome.setText(txtNome.getText().replaceAll("[^a-z||^A-Z||^ ]", ""));
            }
        });
        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtNome.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtUsername = new JTextField(20);
        txtUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtUsername.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });
        
        txtEmail = new JTextField(40);
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtEmail.setText(txtEmail.getText().replaceAll("[^a-z||^A-Z||^@||^.||^-||^_]", ""));
            }
        });
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtEmail.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtPassword = new JPasswordField(20);
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtPassword.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });

        painelNorte.add(criarPainelLabels("Username: ", txtUsername, strErro));
        painelNorte.add(criarPainelLabels("Password: ", txtPassword,""));
        painelNorte.add(criarPainelLabels("Nome:", txtNome,""));
        painelNorte.add(criarPainelLabels("Email:", txtEmail,""));
        
        return painelNorte;
    }
    /**
     * cria painel para introduzir label1, campo para introdução dados e label2
     * @param label1 introduzir label1
     * @param texto campo para introdução dados 
     * @param label2 introduzir label1
     * @return painel para introduzir label1, campo para introdução dados e label2
     */
    private JPanel criarPainelLabels(String label1, JTextField texto, String label2) {
        JLabel lbl1 = new JLabel(label1, JLabel.RIGHT);
        lbl1.setPreferredSize(LABEL_TAMANHO);
        
        JLabel lbl2 = new JLabel(label2, JLabel.LEFT);
        lbl2.setPreferredSize(new Dimension(150,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl1);
        p.add(texto);
        p.add(lbl2);

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
        JButton botao = new JButton("Registar Candidatura");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Registar Candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,
                                "Em construção",
                                "Registar Utilizador",
                                JOptionPane.ERROR_MESSAGE);
                }
            //guardar();
        });

        return botao;
    }
    /**
     * criar botão limpar
     * @return botão limpar
     */
    private JButton criarBotaoLimpar() {
        JButton botao = new JButton("Limpar Candidatura");
        botao.setMnemonic(KeyEvent.VK_L);
        botao.setToolTipText("Limpa dados gerais da candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtUsername.setText("");
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
        botao.setToolTipText("Cancela a atribuição e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanelaRegistoUtilizador();
            }
        });

        return botao;
    }
    
    private void guardar() {
//        this.ficheiroCentroExposicoes.guardar(this.centroExposicoes);
        dispose();
    }
    
    private void fecharJanelaRegistoUtilizador(){
        if (txtNome.getText()!=""||
                        txtEmail.getText()!=""||
                        txtPassword.getText()!=""||
                        txtUsername.getText()!=""){
                    String[] opcoes = {"Sim", "Não"};
                    String pergunta = "Pretende cancelar o registo do utilizador?";
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
