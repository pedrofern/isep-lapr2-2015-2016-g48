/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.controller.*;
import lapr.project.model.*;

/**
 *
 * @author Tomas
 */
public class CriarStandUI extends JFrame {
    
    private JButton btnRegistar, btnLimpar, btnFechar;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 320;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descricao: ").getPreferredSize();
    private JTextField txtDescricao,txtArea;
    private Utilizador user;
    private CentroExposicoes mce;
    private RegistoStands m_listaStands; 
    private CriarStandController m_controller;
    private Stand stand;
    private JList listaStands;


    
    public CriarStandUI(CentroExposicoes ce, Utilizador user) {

        super("Criar Stand");
        
        this.mce=ce;
        this.user=user;
        
        mce=ce;
        m_controller=new CriarStandController(ce);
    
        
        criarComponentes();
        
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    public void criarComponentes() {
        add(criarPainelDados(), BorderLayout.NORTH);
        add(criarPainelSul(), BorderLayout.SOUTH);
    }
    
    private JPanel criarPainelNorte(String label1, JTextField texto, String label2) {
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
    

    
    private JPanel criarPainelDados() {
        JPanel painelNorte = new JPanel( new GridLayout(5,1));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 25, MARGEM_DIREITA = 0;
        painelNorte.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Dados Stand"),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        
        txtDescricao=new JTextField(20);
        txtDescricao.requestFocusInWindow();
        txtDescricao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtDescricao.setText(txtDescricao.getText().replaceAll("[^a-z||^A-Z||^ ]", ""));
            }
        });
        txtDescricao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtDescricao.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        
        txtArea=new JTextField(20);
        txtArea.requestFocusInWindow();
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtArea.setText(txtArea.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtArea.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        painelNorte.add(criarPainelNorte("Descricao: ",txtDescricao,""));
        painelNorte.add(criarPainelNorte("Area: ",txtArea,"m^2"));
        
        
        
        return painelNorte;
    }
    
    private JPanel criarPainelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBotoes());
        return p;
    }
    
    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoConfirmar();
        getRootPane().setDefaultButton(btnOK);
        JButton btnClear = criarBotaoLimpar();
        JButton btnClose = criarBotaoFechar();
        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.add(btnOK);
        p.add(btnClear);
        p.add(btnClose);
        return p;

    }
   
    
//    private JButton criarBotaoRegistarStand() {
//        
//        btnRegistar = new JButton("Registar Stand");
//        btnRegistar.setMnemonic(KeyEvent.VK_R);
//        btnRegistar.setToolTipText("Registar Stand");
//
//        btnRegistar.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//
//                try {
//               
//            
//                   if(txtDescricao.getText()==null|| txtDescricao.getText().trim().isEmpty()&& txtArea.getText()==null|| txtArea.getText().trim().isEmpty()){
//                    JOptionPane.showMessageDialog(null, "Não introduziu dados.");
//                    new CriarStandUI(mce,user);
//                   }
//                   if(stand.getDescricao().equals(txtDescricao.getText()) || stand.getArea().equals(txtArea.getText())){
//                       JOptionPane.showMessageDialog(null, "Stand já existente.");
//                       new CriarStandUI(mce,user);
//                   }else{
//                       JOptionPane.showMessageDialog(null, "Stand criado com sucesso");
//                       guardar();
//                   }
//                   dispose();
//                   
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Tem de preencher todos os campos!",
//                            "Registar Stand",
//                            JOptionPane.ERROR_MESSAGE);
//                   
//            }
//                       
//            }  
//        }
//        );
//        return btnRegistar;
//    }
    
     private JButton criarBotaoConfirmar() {
        JButton botao = new JButton("Registar Stand");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Registar stand");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if( txtDescricao.getText().isEmpty()==true||
                    txtArea.getText().isEmpty()==true)
                    {
                        JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Criar Stand",
                            JOptionPane.ERROR_MESSAGE);                        
                }else{
                        JOptionPane.showMessageDialog(null, "Stand criado com sucesso.\n");
                        guardar();
                }
                dispose();
            }
        });

        return botao;
    }
    
    private void guardar(){

        String descricao=txtDescricao.getText();
        String area = txtArea.getText();
        m_controller.novoStand();
        m_controller.registaStand(descricao,area);
        
        for(Stand s: mce.getRegistoStands().getListaStands()){
             System.out.println(s.toString());
    }
        
    }
    
    
    private JButton criarBotaoFechar() {
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btnFechar;
    }
    
    private JButton criarBotaoLimpar() {
        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                txtDescricao.setText(null);
                txtArea.setText(null);

            }
        });
        return btnLimpar;
    
    }
}
