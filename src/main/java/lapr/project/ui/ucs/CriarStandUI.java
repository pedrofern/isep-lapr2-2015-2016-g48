/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tomas
 */
public class CriarStandUI extends JFrame {
    
    private JButton btnConfirmar, btnLimpar, btnFechar;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 320;
    private JFrame framePai;
    
    public CriarStandUI() {

        super("Criar Stand");
        criarComponentes();
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    public void criarComponentes() {

    }
    
    private JPanel criarPainelOeste() {
        JPanel p = new JPanel(new FlowLayout());
        
    }
    
    private JPanel criarPainelDados() {
        JPanel p = new JPanel(new FlowLayout());
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
        
        JButton btnClose = criarBotaoFechar();
        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.add(btnOK);
        p.add(btnClose);
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

}
