package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.CentroExposicoes;



/**
 *
 * @author Diana
 */
public class Login extends JDialog /**implements Serializable**/ {
    
    private CentroExposicoes m_ce;
    private String id_utilizador;
    // private FicheiroCentroExposicoes fce;
    private static final int WIDTH=300, HEIGHT=300;
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10, MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
    
    
    private JTextField username;
    private JPasswordField password;
    private Login framePai;
    String m_ut;
    //private FicheiroCentroExposicoes ficheiroCentroExposicoes;
    private CentroExposicoes centroExposicoes;
    
    
    
  
    private static final Dimension LABEL_TAMANHO = new JLabel("Username").getPreferredSize();
    
    
  
    public Login(){
        
        this.setTitle("Menu Login");
        
        criarComponentes();
        criarPainelBotoes();
         
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
       
    }    
        
    
    public Login(CentroExposicoes ce,String u){
        
        this.setTitle("Menu Login");
        this.m_ce=ce;
        this.m_ut=u;
        
        
        criarComponentes();
        criarPainelBotoes();
        
         
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
       
        
        
    }
        
    private void criarComponentes(){
        
        add(criarPainelNorte(), BorderLayout.NORTH);
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
        
        p.setBorder(new TitledBorder("LOGIN"));
        return p;
    }
    
    private JPanel criarPainelSul(){
        
        JPanel p = new JPanel(new GridLayout(0, 1));
         
        p.add(criarBotaoRegistar());
        
         
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("REGISTO"));
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
              
                new Janela(m_ce, id_utilizador);  

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
    
//    private void terminar() {
//        this.ficheiroCentroExposicoes.guardar(this.centroExposicoes);
//        dispose();
//    }
    
    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                terminar();
                dispose();
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
                
                if(username.getText().equals("Admin")){
                    new Janela(m_ce,"Admin");
                    framePai.setVisible(false);
                }
                    if(username.equals("FAE")){
                       new Janela(m_ce, m_ut); 
                    }
                        if(username.equals("Organizador")){
                            new Janela(m_ce, m_ut); 
                        }
                else
                            if(username.equals("Gestor")){
                                 new Janela(m_ce, m_ut); 
                            }
                else
                                if(username.equals("Representante")){
                                     new Janela(m_ce, m_ut); 
                                }
                              
                

            }
        });
        return btn;
    }
    
}
