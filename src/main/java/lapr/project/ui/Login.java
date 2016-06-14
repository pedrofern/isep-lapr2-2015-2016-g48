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

    private static final Dimension LABEL_TAMANHO = new JLabel("Username").getPreferredSize();        
    
    public Login(CentroExposicoes ce){
        
        super("Menu Login");
        this.m_ce=ce;
        
        //Para teste
                     Utilizador ut1=new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true,15 );
                     
                    Utilizador ut2= new Utilizador("Ana Silva", "1130155@isep.ipp.pt","Gestor",true,10);
                    Utilizador ut3= new Utilizador("Diana Silva", "1151088@isep.ipp.pt","Organizador",true,8);
                    Utilizador ut4= new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt","Organizador+Fae",true, 6);
                    Utilizador ut5= new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt","Fae",true,3);
                    Utilizador ut6= new Utilizador("Tomás Magalhães" , "1151182@isep.ipp.pt","Representante",true,1);
                   
            
                   RegistoUtilizadores lu = m_ce.getRegistoUtilizadores();
                   lu.addUtilizador(ut1);
                   lu.addUtilizador(ut2);
                   lu.addUtilizador(ut3);
                   lu.addUtilizador(ut4);
                   lu.addUtilizador(ut5);
        

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
                
//                 for (Utilizador u: m_ce.getRegistoUtilizadores().getListaUtilizadores()){
//                    System.out.println(u.toString());
//                }
            
                 for(Utilizador u: m_ce.getRegistoUtilizadores().getListaUtilizadores()){
     
                     if(username.getText().equalsIgnoreCase(u.getUsername())){
            
                        if(u.getRegistado()!= false){
                        JOptionPane.showMessageDialog(null, "Utilizador válido. Bem vindo!");
                        new Janela (m_ce, u);
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");
                        new RegistarUtilizadorUI(m_ce);  
                    }
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
