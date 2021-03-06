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
public class DialogoProdutoAlterarCandidatura extends JDialog {
    /**
     * Guarda o texto introduzido do produto
     */
    private JTextField txtProduto;
    /**
     * Guardar a janela anterior
     */
    private AlterarCandidaturaUI framePai;
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
    public DialogoProdutoAlterarCandidatura( AlterarCandidaturaUI framePai ) { 

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

        final int CAMPO_LARGURA = 10;
        txtProduto = new JTextField(CAMPO_LARGURA);
        txtProduto.requestFocusInWindow();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

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
