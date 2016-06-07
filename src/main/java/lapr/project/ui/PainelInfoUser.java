package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Diana
 */
public class PainelInfoUser extends JPanel {
    
    private String m_user;
    
    public PainelInfoUser(String ut){
        super();
        this.m_user=ut;
        
        setLayout(new BorderLayout());
    }
    
    public void criarPainel(){
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelCentro(),BorderLayout.CENTER);
        add(criarPainelEste(), BorderLayout.EAST);
    
    }

    private JPanel criarPainelOeste(){
        
        JPanel p=new JPanel();
        
        JLabel label=new JLabel();
        
        label.setBounds(80,130,130,80);
        
        switch (m_user){
            case "Organizador":
                
                 try{
    
                    ImageIcon org=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/org.jpg"));
  
                    org=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/org.jpg"));
                    Image imgOrg=org.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(imgOrg));
                    
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                } 
     
                break;
                
            case "Fae":

                 try{
           
                    ImageIcon fae=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/fae.jpg"));
   
                    fae=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/fae.jpg"));
                    Image imgFae=fae.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(imgFae));
                   
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                } 

                break;
                
            case "Representante":
                
                
                 try{
                    ImageIcon rep=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/rep.jpg"));
        
                    rep=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/rep.jpg"));
                    Image imgRep=rep.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(imgRep));
                 }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                 } 

                 break;
                 
            case "Organizador+Fae":
                
                 try{
                     
                     ImageIcon fae_org=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/fae+org.jpg"));
    
                     fae_org=new ImageIcon(PainelInfoUser.class.getResource("/main/java/lapr/project/ui/imagens/fae+org.jpg"));
                     Image img=fae_org.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                     label.setIcon(new ImageIcon(img));
                     
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");} 
     
                break;
            default:
                //gestor
//                Image imgGestor=org.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
//                label.setIcon(new ImageIcon(imgGestor));       
        }
         
        p.add(label);
        
        return p;
    }
    
    private JPanel criarPainelCentro(){
        JPanel p= new JPanel();
        
        JPanel pDados=new JPanel();

        GridLayout gl=new GridLayout(3,1);
        
        pDados.setLayout(gl);
        
        JLabel lblNome=new JLabel("Nome"); 
        JLabel lblEmail=new JLabel("Email");
        JLabel lblUsername=new JLabel("Username");

        pDados.add(lblUsername);
        pDados.add(lblNome);
        pDados.add(lblEmail);
        
        p.setLayout(new BorderLayout());
        p.add(pDados, BorderLayout.WEST);
 
        return p;
    }
    
    private JPanel criarPainelEste(){

        JLabel labelLogo=new JLabel();
        JPanel p= new JPanel();   
        
        labelLogo.setBounds(80,80,80,80);
        
        //Image img=logo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH);
        
        //labelLogo.setSize(6,8);
        //labelLogo.setIcon(logo);
        
//        labelLogo.setIcon(new ImageIcon(img));
        
        p.add(labelLogo,BorderLayout.EAST);
        
        return p;
    }

}

