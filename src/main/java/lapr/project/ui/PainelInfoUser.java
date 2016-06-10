package lapr.project.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lapr.project.model.Utilizador;

/**
 *
 * @author Diana
 */
public class PainelInfoUser extends JPanel {
    
    private Utilizador m_user;
    private String tipo_utilizador;
    
    public PainelInfoUser(Utilizador user){
        super();
        this.m_user=user;
        
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
        
        tipo_utilizador="Admin";
        switch (tipo_utilizador){
            case "Organizador":
                
                 try{

                    ImageIcon org=new ImageIcon("src/main/resources/images/org.jpg");
                    Image imgOrg=org.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(imgOrg));
                    
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                } 
     
                break;
                
            case "Fae":

                 try{
           
                    ImageIcon fae=new ImageIcon("src/main/resources/images/fae.jpg");
   
                    Image imgFae=fae.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(imgFae));
                   
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                } 

                break;
                
            case "Representante":      
                 try{
                    ImageIcon rep=new ImageIcon("src/main/resources/images/rep.jpg");
   
                    Image imgRep=rep.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(imgRep));
                 }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                 } 

                 break;
                 
            case "Organizador+Fae":
                
                try{
                     
                     ImageIcon fae_org=new ImageIcon("src/main/resources/images/fae+org.jpg");
    
                     Image img=fae_org.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                     label.setIcon(new ImageIcon(img));
                     
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                } 
     
                break;
            case "Gestor":
                
                try{
                    ImageIcon gestor=new ImageIcon("src/main/resources/images/gestor.jpg");
    
                    Image img=gestor.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(img));
                }catch(Exception ex){
                    label.setText("ImagemNãoEncontrada");
                }
            default:
                //Admin
                  
                  ImageIcon admin=new ImageIcon("src/main/resources/images/admin.jpg");
                  Image img=admin.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                  label.setIcon(new ImageIcon(img));       
        }
         
        p.add(label);
        
        return p;
    }
    
    private JPanel criarPainelCentro(){
        JPanel p= new JPanel();
        
        JPanel pDados=new JPanel();

        GridLayout gl=new GridLayout(3,1);
        
        pDados.setLayout(gl);
        
        JLabel lblNome=new JLabel("Nome: " + m_user.getNome()); 
        JLabel lblEmail=new JLabel("Email: " + m_user.getEmail());
        JLabel lblUsername=new JLabel("Username: " + m_user.getUsername());

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
        
        
        try{
            ImageIcon logo=new ImageIcon("src/main/resources/images/logo.jpeg");
            
            Image img=logo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH);
        
            labelLogo.setSize(6,8);
            labelLogo.setIcon(logo);
        
            labelLogo.setIcon(new ImageIcon(img));    
            
                     
        }catch(Exception ex){
            labelLogo.setText("ImagemNãoEncontrada");
        } 
     
        
        
        p.add(labelLogo,BorderLayout.EAST);
        
        return p;
    }

}

