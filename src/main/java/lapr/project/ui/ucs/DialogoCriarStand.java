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
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr.project.model.*;

/**
 *
 * @author anasilva
 */
public class DialogoCriarStand extends JDialog{
    
    /**
     * Guarda o texto introduzido do stand
     */
    private JTextField txtDescricao,txtArea;
    /**
     * Guarda a janela anterior
     */
    private CriarStandUI framePai;
    /**
     * Define um tamanho standard para as label
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Recurso: ").
                                                        getPreferredSize();
    /**
     * Constrói uma caixa dialogo para guardar o recurso,
     * recebendo a janela anterior como parametro
     * @param framePai janela anterior
     */
    public DialogoCriarStand( CriarStandUI framePai ) { 

        super(framePai, "Novo Stand", true);

        this.framePai = framePai;

        criarComponentes();
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    /**
     * cria os componentes da janela
     */
    private void criarComponentes(){
        JPanel p1 = criarPainelNome();
        JPanel p2 = criarPainelBotoes();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
    }
    /**
     * cria painel para colocar o nome do recurso
     * @return painel para colocar o nome do recurso
     */
    private JPanel criarPainelNome() {
        JLabel lbl = new JLabel("Stand: ", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        txtDescricao = new JTextField(CAMPO_LARGURA);
        txtDescricao.requestFocusInWindow();
        txtArea = new JTextField(CAMPO_LARGURA);
        txtArea.requestFocusInWindow();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(txtDescricao);
        p.add(txtArea);

        return p;
    }
    /**
     * cria painel com os botões OK e Cancelar
     * @return painel com os botões OK e Cancelar
     */
    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoOK();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = criarBotaoCancelar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOK);
        p.add(btnCancelar);

        return p;
    }
    /**
     * cria botão OK
     * @return botão OK
     */
    private JButton criarBotaoOK() {
        JButton btn = new JButton("OK");
        btn.setMnemonic(KeyEvent.VK_O);
        btn.setToolTipText("Confirma adição recurso");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stand novoStand = new Stand(txtDescricao.getText(),txtArea.getText());
                JList lista = framePai.getListaStands();
                ModeloListaStands modeloListaStands = (ModeloListaStands) lista.getModel();
                boolean standAdicionado = modeloListaStands.addElement(novoStand);
                if (standAdicionado) {   
                        framePai.criarBotaoRemoverStand().setEnabled(true);
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Stand adicionado à lista de stands.",
                                "Novo Stand",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Stand já incluído na lista de stands!",
                                "Novo Stand",
                                JOptionPane.ERROR_MESSAGE);
                    }
                dispose();
            }
        });
        return btn;
    }
    /**
     * cria botão Cancelar
     * @return botão Cancelar
     */
    private JButton criarBotaoCancelar() {
        JButton btn = new JButton("Cancelar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }  
    
}
