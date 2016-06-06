package lapr.project.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import lapr.project.model.CentroExposicoes;

/**
 *
 * @author Diana
 */
public class Login extends JDialog /**implements Serializable**/ {
    
    private CentroExposicoes m_ce;
    private String id_utilizador;
    // private FicheiroCentroExposicoes fce;
    
    public Login(CentroExposicoes ce){
        
        this.setTitle("Login");
        this.m_ce=ce;
        
        this.setVisible(true);
    }
    
    private JButton criarBotaoOK() {
        JButton btn = new JButton("Login");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //CentroExposicoes ce=new CentroExposicoes();   
                
                new Janela(m_ce, id_utilizador);  

            }
        });
        return btn;
    }
}
