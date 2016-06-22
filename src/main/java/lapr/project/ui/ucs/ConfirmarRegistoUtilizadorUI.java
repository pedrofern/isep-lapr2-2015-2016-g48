package lapr.project.ui.ucs;

import java.awt.BorderLayout;
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
    private JPanel pUtilizadores,painel;
    private JButton btnConfirmar;
    private Utilizador ut;
    private RegistoUtilizadores registoUt;
    private String pergunta="Pretende cancelar a confirmacao do registo de utilizador?";
    
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;


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
        
       painel=new JPanel();
       painel.setLayout(new BorderLayout());
       
       painel.add(criarPainelNorte(),BorderLayout.NORTH);
       
        
       painel.add(pUtilizadores, BorderLayout.CENTER);
       painel.add(criarPainelBotoes(), BorderLayout.SOUTH);
       
       add(painel);
    }
    
    private JPanel criarPainelNorte(){
        
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Utilizadores"));
        JLabel lbl = new JLabel("Selecione um utilizador para confirmacao", SwingConstants.RIGHT);
        p.add(lbl);
        criarPainelUtilizadores();
        return p;
        
        
    }
    
    
    
    private void criarPainelUtilizadores(){
       
        pUtilizadores=new JPanel();
//        String[] opcoes={"Ut 1", "Ut 2"};
//        comboUtilizadores=new JComboBox(opcoes);
        
        registoUt =ce.getRegistoUtilizadores();
      
        
        
        pUtilizadores.add(Utils.criarComboUser(registoUt));
        
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
                if(comboUtilizadores.getSelectedItem()!=null){
                    
                    JOptionPane.showMessageDialog(null,"Não selecionou um utilizador. Volte a tentar.");
                    
                }else{
                    
                   
                }
             }
         });
         return btnConfirmar;
    }
               
//             
               
     
//     private JButton criarBotaoConfirmar(){
//         
//         
//     }
     
     private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela a confirmacao do registo de utilizador e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarJanelaConfirmaRegistoUtilizador(pergunta);
            }
        });

        return botao;
    }
     
     private void guardarJanelaConfirmaRegistoUtilizador(String pergunta){
        if (comboUtilizadores.getSelectedItem()!=null){
                
            String[] opcoes = {"Sim", "Não"};
            
            int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                    "Confirmar registo utilizador", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (opcao == JOptionPane.YES_OPTION) {                        
                dispose();
            } else {
                 setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                       
            }
        }
    }
     
     
     
    
    
    

    
//    public void run() {
//        System.out.println("Confirmar Registo Utilizador:");
//
//        do {
//            List<Utilizador> lUsers = controller.iniciaConfirmacaoUtilizador();
//            mostraUtilizadores(lUsers);
//            selecionaUtilizador();
//
//            System.out.print("continuar (s/n)?");
//        } while ("s".equalsIgnoreCase(ler.nextLine()));
//    }

//    public void mostraUtilizadores(List<Utilizador> lUsers) {
//        System.out.println("Utilizadores");
//        System.out.println("------------");
//        for (Utilizador u : lUsers) {
//            System.out.printf("[%s] : %s\n", u.getUsername(), u.getEmail());
//        }
//    }
//
//    public void selecionaUtilizador() {
//        System.out.print("Username?:");
//        String uId = ler.nextLine();
//
//        Utilizador u = controller.getUtilizadorInfo(uId);
//
//        if (u == null || u.getRegistado()) {
//            System.out.println("ERRO: utilizador invalido para confirmacao");
//        } else {
//            System.out.println(u.toString());
//            System.out.print("confirma (s/n)?");
//            if ("s".equalsIgnoreCase(ler.nextLine())) {
//
//                controller.confirmaRegistoUtilizador();
//                System.out.println("sucesso");
//            }
//        }
    }


