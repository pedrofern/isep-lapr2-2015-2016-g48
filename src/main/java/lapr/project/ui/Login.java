package lapr.project.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import lapr.project.model.CentroExposicoes;

/**
 *
 * @author Diana
 */
public class Login extends JDialog /**implements Serializable**/ {
    
    private CentroExposicoes m_ce;
    private String id_utilizador;
    // private FicheiroCentroExposicoes fce;
    private static final int WIDTH=300, HEIGHT=200;
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10, MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
    
    
    public Login(CentroExposicoes ce){
        
        this.setTitle("Login");
        this.m_ce=ce;
        
        JButton bt=new JButton();
        bt=criarBotaoOK();
        add(bt);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private JButton criarBotaoOK() {
        JButton btn = new JButton("Login");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id_utilizador="admin";
                
                new Janela(m_ce, id_utilizador);  

            }
        });
        return btn;
    }
}
