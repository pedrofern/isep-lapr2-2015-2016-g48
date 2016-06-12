package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr.project.model.Utilizador;

/**
 *
 * @author Diana Silva
 */
public class PainelDadosUtilizador extends JPanel{
   
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
 
    private JPanel painelNorte;
    private JPanel painelEmail;
   
    public PainelDadosUtilizador(){
        super();
        
        setLayout(new BorderLayout());
        
        add(criarPainelDadosUtilizador());
 
    }
    
    private JPanel criarPainelDadosUtilizador(){
        painelNorte = new JPanel( new GridLayout(4,1));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 25, MARGEM_DIREITA = 0;
        painelNorte.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Dados Utilizador"),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        txtNome = new JTextField(40);
        getTxtNome().requestFocusInWindow();
        getTxtNome().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                getTxtNome().setText(getTxtNome().getText().replaceAll("[^a-z||^A-Z||^ ]", ""));
            }
        });
        getTxtNome().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (getTxtNome().getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtUsername = new JTextField(20);
        getTxtUsername().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (getTxtUsername().getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });
        
        txtEmail = new JTextField(40);
        getTxtEmail().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                getTxtEmail().setText(getTxtEmail().getText().replaceAll("[^a-z||^A-Z||^@||^.||^-||^_]", ""));
            }
        });
        getTxtEmail().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (getTxtEmail().getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtPassword = new JPasswordField(20);
        getTxtPassword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (getTxtPassword().getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });

        painelNorte.add(criarPainelLabels("Username: ", getTxtUsername(), strErro));
        painelNorte.add(criarPainelLabels("Password: ", getTxtPassword(),""));
        painelNorte.add(criarPainelLabels("Nome:", getTxtNome(),""));
        
        painelEmail=criarPainelLabels("Email:", getTxtEmail(),"");      
        painelNorte.add(painelEmail);

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
     * @return the txtNome
     */
    public JTextField getTxtNome() {
        return txtNome;
    }

    /**
     * @return the txtEmail
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * @return the txtUsername
     */
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    /**
     * @return the txtPassword
     */
    public JPasswordField getTxtPassword() {
        return txtPassword;
    }
 
    public void desativarUserNamePainelNorte(){
        txtUsername.setEnabled(false);
    } 

    public void preencherDadosUtilizador(Utilizador ut){
        txtNome.setText(ut.getNome());
        txtEmail.setText(ut.getEmail());
        txtPassword.setText(ut.getPassword());
        txtUsername.setText(ut.getUsername());
    }
    
 
   
    
}
