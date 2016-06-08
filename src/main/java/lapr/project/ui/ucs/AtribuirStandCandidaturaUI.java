/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tomas
 */
public class AtribuirStandCandidaturaUI extends JFrame {

    private JButton btnConfirmar, btnLimpar, btnFechar;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 320;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Area de Stand").getPreferredSize();
    private JComboBox comboboxExposicao;
    
    public AtribuirStandCandidaturaUI() {

        super("Atribuir Stand Candidatura");
        criarComponentes();
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    public void criarComponentes() {
        add(criarPainelCentro(), BorderLayout.CENTER);
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelEste(), BorderLayout.EAST);
    }
    
    private JPanel criarPainelCentro(){
        JPanel p = new JPanel(new FlowLayout());
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.setBorder(new TitledBorder("Stands"));

        return p;
    }
    
    private JPanel criarPainelEste(){
        JPanel p = new JPanel(new FlowLayout());
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.setBorder(new TitledBorder("Candidaturas"));

        return p;
    }
    
    private JPanel criarPainelOeste(){
    JPanel p = new JPanel(new FlowLayout());
        p.add(criarPainelExposicao());
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.setBorder(new TitledBorder("Exposição"));

        return p;
    }
    
    private JPanel criarPainelExposicao() {

        JPanel p = new JPanel(new FlowLayout());
        
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(getListaExposicao());
        return p;

    }
    
    private JComboBox getListaExposicao() {

        comboboxExposicao = new JComboBox();
        comboboxExposicao.setEditable(false);
        comboboxExposicao.setSelectedIndex(-1);
        comboboxExposicao.setPreferredSize(new Dimension(200, 20));

        return comboboxExposicao;
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
        return btnLimpar;

    }
}
