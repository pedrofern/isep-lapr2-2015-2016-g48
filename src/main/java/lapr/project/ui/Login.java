package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import lapr.project.model.CentroExposicoes;
import lapr.project.ui.ucs.RegistarUtilizadorUI;
import lapr.project.model.lists.*;
import lapr.project.model.*;


/**
 *
 * @author Diana
 */
public class Login extends JFrame /**implements Serializable**/ {
    
    private CentroExposicoes m_ce;
    private String id_utilizador;
    // private FicheiroCentroExposicoes fce;
    private static final int WIDTH=300, HEIGHT=250;
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0, MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;

    private JTextField username;
    private JPasswordField password;
    private Login framePai;
    private String m_ut;
    //private FicheiroCentroExposicoes ficheiroCentroExposicoes;
    private CentroExposicoes centroExposicoes;
  

    private static final Dimension LABEL_TAMANHO = new JLabel("Username").getPreferredSize();        
    
    public Login(CentroExposicoes ce){
        
        super("Menu Login");
        this.m_ce=ce;

        framePai = Login.this;
        
        criarComponentes();
        criarPainelBotoes();
        
         
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanela();
            }
        });
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
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
        
         
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("Login"));
        return p;
    }
    
    private JPanel criarPainelSul(){
        
        JPanel p = new JPanel(new GridLayout(0, 1));
         
        p.add(criarBotaoRegistar());
        
         
        final int MARGEM_SUPERIOR = 5, MARGEM_INFERIOR = 5;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("Registar Novo Utilizador"));
        return p;
    }
        
    private JPanel criarPainelUsername(){
        
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Username", SwingConstants.LEFT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        username = new JTextField(CAMPO_LARGURA);
        username.requestFocus();

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
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

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(password);

        return p;
    
        
    }
    
    private JButton criarBotaoRegistar(){
        
        JButton btn = new JButton("Registar");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new RegistarUtilizadorUI(m_ce);  
                
            }
        });
        return btn;

    }
    
    private JPanel criarPainelBotoes() {
        
    JButton btnOK = criarBotaoLogin();
        getRootPane().setDefaultButton(btnOK);

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
                
                //CentroExposicoes ce=new CentroExposicoes();
                
                
                
                //Para teste
                    Utilizador ut1= new Utilizador("1130155@isep.ipp.pt","Ana",true);
                    Utilizador ut2= new Utilizador("1130155@isep.ipp.pt","Filipe",true);
                    Utilizador ut3= new Utilizador("1151182@isep.ipp.pt","Tomas",true);
                    Utilizador ut4= new Utilizador("1151094@isep.ipp.pt","Eduangelo",true);
                    Utilizador ut5= new Utilizador("1151088@isep.ipp.pt","Diana",true);
                    
                   RegistoUtilizadores lu = new RegistoUtilizadores();
                   lu.addUtilizador(ut1);
                   lu.addUtilizador(ut2);
                   lu.addUtilizador(ut3);
                   lu.addUtilizador(ut4);
                   lu.addUtilizador(ut5);

                 
                    if(username.getText().equalsIgnoreCase(ut1.getUsername())){
                        if(ut1.getRegistado()!= false){
                        JOptionPane.showMessageDialog(null, "Utilizador valido. Bem vindo!");
                        new Janela (m_ce, ut1);
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");
                        new RegistarUtilizadorUI(m_ce);  
                    }
                    }
                    if(username.getText().equalsIgnoreCase(ut2.getUsername())){
                         if(ut2.getRegistado()!= false){
                        JOptionPane.showMessageDialog(null, "Utilizador valido. Bem vindo!");
                        new Janela (m_ce, ut2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");
                        new RegistarUtilizadorUI(m_ce);  
                    }
                    }
                    if(username.getText().equalsIgnoreCase(ut3.getUsername())){
                        if(ut3.getRegistado()!= false){
                        JOptionPane.showMessageDialog(null, "Utilizador valido. Bem vindo!");
                        new Janela (m_ce, ut3);
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");
                        new RegistarUtilizadorUI(m_ce);  
                    }
                    }
                    if(username.getText().equalsIgnoreCase(ut4.getUsername())){
                         if(ut4.getRegistado()!= false){
                        JOptionPane.showMessageDialog(null, "Utilizador valido. Bem vindo!");
                        new Janela (m_ce, ut4);
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");
                        new RegistarUtilizadorUI(m_ce);  
                    } 
                    }
                    if(username.getText().equalsIgnoreCase(ut5.getUsername())){
                        if(ut5.getRegistado()!= false){
                        JOptionPane.showMessageDialog(null, "Utilizador valido. Bem vindo.");
                        new Janela (m_ce, ut5);
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");
                        new RegistarUtilizadorUI(m_ce); 
                    }
                    }
               
                dispose();
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
//        this.ficheiroCentroExposicoes.guardar(this.centroExposicoes);
        System.exit(0);
    }
}
