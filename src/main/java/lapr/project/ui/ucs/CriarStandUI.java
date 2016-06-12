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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;

/**
 *
 * @author Tomas
 */
public class CriarStandUI extends JFrame {
    
    private static CentroExposicoes m_ce;
    
    private JButton btnConfirmar, btnLimpar, btnFechar;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 320;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Area de Stand").getPreferredSize();
    private JTextField txtID,txtDescricao,txtArea;

    
    public CriarStandUI(CentroExposicoes ce) {

        super("Criar Stand");
        
        m_ce=ce;
        criarComponentes();
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
        
    }
    
    public void criarComponentes() {
        add(criarPainelCentro(), BorderLayout.CENTER);
        add(criarPainelSul(), BorderLayout.SOUTH);
    }
    
    private JPanel criarPainelCentro() {
        JPanel p = new JPanel(new GridLayout(0, 1));
        p.add(criarPainelID());
        p.add(criarPainelDescricao());
        p.add(criarPainelArea());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.setBorder(new TitledBorder("Dados do Stand"));
        return p;
    }
    
    private JPanel criarPainelID(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("ID:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtID = new JTextField(CAMPO_LARGURA);
        txtID.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtID);

        return p;

    }
    
    private JPanel criarPainelDescricao(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Descrição:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtDescricao = new JTextField(CAMPO_LARGURA);
        txtDescricao.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtDescricao);

        return p;

    }
    
    private JPanel criarPainelArea(){
        JLabel lbl = new JLabel("Área:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        
        final int CAMPO_LARGURA = 30;
        txtArea = new JTextField(CAMPO_LARGURA);
        txtArea.requestFocus();
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtArea);

        return p;
    }
    
    private JPanel criarPainelDados() {
        JPanel p = new JPanel(new FlowLayout());
        return p;
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
        p.add(btnOK);
        p.add(btnClose);
        p.add(btnClear);
        return p;

    }
    
    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        return btnConfirmar;
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
                txtID.setText(null);
                txtDescricao.setText(null);
                txtArea.setText(null);

            }
        });
        return btnLimpar;
    
    }

}
