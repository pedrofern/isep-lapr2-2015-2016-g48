package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import lapr.project.controller.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.*;


/**
 *
 * @author Pedro Fernandes
 */
public class ConfirmarRegistoUtilizadorUI extends JFrame{

   private final ConfirmarRegistoUtilizadorController controller;
    private static CentroExposicoes ce;
    private JComboBox comboUtilizadores;
    private RegistoUtilizadores lista;
    private JPanel pUtilizadores;
    private JButton btnConfirmar;
    private String pergunta="Pretende confirmar o registo de utilizador?";
    
    private static final int JANELA_LARGURA = 700;
    private static final int JANELA_ALTURA = 300;


    public ConfirmarRegistoUtilizadorUI(CentroExposicoes centroExposicoes) {
        super("Confirmar Registo Utilizador");
        ce=centroExposicoes;
        controller = new ConfirmarRegistoUtilizadorController(ce);
  
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void criarComponentes(){
        
       
       
       add(criarPainelNorte(),BorderLayout.NORTH);
       add(criarPainelUtilizador());
       add(criarPainelBotoes(), BorderLayout.SOUTH);
       
    
    }
    
    private JPanel criarPainelNorte(){
        
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Utilizadores"));
        JLabel lbl = new JLabel("Selecione um utilizador para confirmacao", SwingConstants.RIGHT);
        p.add(lbl);
        //criarPainelUtilizador();
        return p;
        
        
    }
  
    
    private JPanel criarPainelUtilizador(){
        
        pUtilizadores = new JPanel(new FlowLayout());
        pUtilizadores.setPreferredSize(new Dimension(200, getHeight()));
        pUtilizadores.setBorder(new EmptyBorder(0, 10, 0, 10));
        pUtilizadores.add(getComboUtilizadores(), BorderLayout.NORTH);
        
        return pUtilizadores;
    }
    
    
    private JComboBox getComboUtilizadores() {
        
        
        comboUtilizadores = Utils.criarComboUser(controller.getRegistoUtilizadores().getUtilizadoresPend());
        return comboUtilizadores;
    }
    
   
      
  
     private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);

        JButton bt1 = criarBotaoConfirmar();
        JButton bt2 = criarBotaoCancelar();
        
        p.add(bt1);
        p.add(bt2);
   
        
        return p;
    }
     
    
     
     private JButton criarBotaoConfirmar(){
        
         btnConfirmar = new JButton("Confirmar");
         
         btnConfirmar.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 guardar();
            
             }
            
         }
 
         );
         return btnConfirmar;
    }
               
     
     private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela a confirmacao do registo de utilizador e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                dispose();
            }
        });

        return botao;
    }
     
     private void guardar(){
         
        Utilizador u = new Utilizador();
        u=(Utilizador)comboUtilizadores.getSelectedItem();
        u.setRegistado(true);
     
//        controller.getRegistoUtilizadores().novoUtilizador();
//        controller.getRegistoUtilizadores().getUtilizadoresPend();
//        controller.confirmaRegistoUtilizador();
         
        for(Utilizador ut: ce.getRegistoUtilizadores().getListaUtilizadores()){
             System.out.println(ut.toString());
     }
     
    
    }

    }


