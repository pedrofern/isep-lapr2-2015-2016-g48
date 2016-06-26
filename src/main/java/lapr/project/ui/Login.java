package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import lapr.project.model.CentroExposicoes;
import lapr.project.ui.ucs.RegistarUtilizadorUI;
import lapr.project.model.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.utils.Utils;


/**
 *
 * @author Diana
 * Modificado por Pedro Fernandes 23/06/2016
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Login extends JFrame {
    
    private CentroExposicoes ce;
    private Exposicao expo;
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0, MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
    private JTextField username;
    private JPasswordField password;
    private Login framePai;
    private Utilizador user;
    private JButton btnOK;
    /**
     * Guarda objectos do tipo FichCentroExposicoes
     */
    private FichCentroExposicoes fichCentroExposicoes;
    private JFileChooser fileChooser;

    private static final Dimension LABEL_TAMANHO = new JLabel("Username").getPreferredSize();        
    
    public Login(CentroExposicoes ce,FichCentroExposicoes fichCentroExposicoes){
        
        super("Menu Login");
        this.fichCentroExposicoes = fichCentroExposicoes;
        this.ce=ce;

        framePai = Login.this;

        criarComponentes();
        criarPainelBotoes();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanela();
            }
        });
        
        setMinimumSize(new Dimension(350,250));
        setLocationRelativeTo(null);
        setVisible(true);

    }
        
    private void criarComponentes(){
        
        add(criarPainelNorte(), BorderLayout.CENTER);
        add(criarPainelSul(),BorderLayout.SOUTH);

    }
    
    private JPanel criarPainelNorte(){
        
        JPanel p = new JPanel(new GridLayout(0, 1));
         
        p.add(criarPainelUsername());
        p.add(criarPainelPassword());
        p.add(criarPainelBotoes());

        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("Login"));
        return p;
    }
    
    private JPanel criarPainelSul(){
        
        JPanel p = new JPanel(new GridLayout(1, 1));
         
        p.add(criarBotaoRegistar());
        
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("Outras Opções"));
        return p;
    }
        
    private JPanel criarPainelUsername(){
        
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Username", SwingConstants.LEFT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        username = new JTextField(CAMPO_LARGURA);
        username.requestFocus();


        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(username);

        return p;
        
    }  
    
    private JPanel criarPainelPassword(){
        
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Password", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        password = new JPasswordField(CAMPO_LARGURA);
        password.requestFocus();

        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(password);

        return p;      
    }
    
    private JButton criarBotaoRegistar(){
        
        JButton btn = new JButton("Registar Novo Utilizador");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                RegistarUtilizadorUI ru = new RegistarUtilizadorUI(ce,fichCentroExposicoes);  
            }
        });
        return btn;
    }

    private JPanel criarPainelBotoes() {
        
        btnOK = criarBotaoLogin();

        JButton btnCancelar = criarBotaoSair();
        JButton btnLimpar   = criarBotaoLimpar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(btnOK);
        p.add(btnCancelar);
        p.add(btnLimpar);
        
        getRootPane().setDefaultButton(btnOK);
        
        return p;
    }
    
    private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                username.setText(null);
                password.setText(null);         
            }
        });
        return btn;
    }
    
    
    
    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });
        return btn;
    }
    
    private JButton criarBotaoLogin() {
        JButton btn = new JButton("Login");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                              
                if (username.getText().isEmpty() || password.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tem de preencher todos os campos.");
                } else {
                    String pass = password.getText();
                    pass = Utils.encriptar(pass);  
                    for (Utilizador u : ce.getRegistoUtilizadores().getListaUtilizadores()) {
                        if (username.getText().equals(u.getUsername()) && pass.equals(u.getPassword())) {
                            if (u.getRegistado()) {
                                user = u;                                
                            }
                        }
                    }
                    if (user==null){
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");     
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador válido. Bem vindo!");
                        Janela j = new Janela(ce, fichCentroExposicoes, user);
                        dispose();
                    }
                    
                }  
            }
        });
        return btn;
    }
    
    private void fecharJanela() {
        String[] opcoes = {"Sim", "Não"};
        String pergunta = "Pretende fechar a aplicação?";
        int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                "Confirma?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            terminar();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void terminar() {
        this.fichCentroExposicoes.guardarFichBinario(this.ce);
        dispose();
    }
}
