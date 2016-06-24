/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import lapr.project.model.Produto;
/**
 * Classe para introduzir um novo Produto numa candidatura
 * @author Pedro Fernandes
 */
public class DialogoNovoProduto extends JDialog {
    /**
     * Guarda o texto introduzido do produto
     */
    private JTextField txtProduto;
    /**
     * Guardar a janela anterior
     */
    private RegistarCandidaturaUI framePai;
    /**
     * Define um tamanho standard para as label
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Produto: ").
                                                        getPreferredSize();
    /**
     * Constrói uma caixa dialogo para guardar o produto na candidatura,
     * recebendo a janela anterior como parametro
     * @param framePai janela anterior
     */
    public DialogoNovoProduto( RegistarCandidaturaUI framePai ) { 

        super(framePai, "Novo Produto", true);

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
     * cria painel para colocar o nome do produto
     * @return painel para colocar o nome do produto
     */
    private JPanel criarPainelNome() {
        JLabel lbl = new JLabel("Produto: ", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

       
        txtProduto = new JTextField(10);
        txtProduto.requestFocusInWindow();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        p.setBorder(new EmptyBorder(10, 10,
                0, 0));

        p.add(lbl);
        p.add(txtProduto);

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
       
        p.setBorder(new EmptyBorder(0, 10,
               10, 10));
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
        btn.setToolTipText("Confirma adição produto");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto novoProduto = new Produto(txtProduto.getText());
                JList lista = framePai.getLstProdutos();
                ModeloListaProdutos modeloListaProdutos = (ModeloListaProdutos) lista.getModel();
                boolean produtoAdicionado = modeloListaProdutos.addElement(novoProduto);
                if (produtoAdicionado) {   
                        framePai.getBotaoRemoverProduto().setEnabled(true);
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Produto adicionado à lista de produtos.",
                                "Novo Produto",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Produto já incluído na lista de produtos!",
                                "Novo Produto",
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
