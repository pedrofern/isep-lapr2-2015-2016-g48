/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.ui.*;
import lapr.project.model.lists.*;

public class DefinirDemonstracaoUI extends JFrame {

    private JButton btnConfirmar, btnCancelar, btnAdicionarRecurso;
    private JComboBox comboBoxExposicao;
    private JTextArea txtDescricao = new JTextArea();
    private JFrame framepai;
    private ModeloListaRecursos modeloListaRecurso;
    private JList listaCompletaRecurso;
    private RegistoRecursos listaRecurso;
    private JTable tableListaRecurso;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public DefinirDemonstracaoUI() throws FileNotFoundException {

        super("Criar Demonstração");
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelListas(), BorderLayout.CENTER);
    }

    private JPanel criarPainelNorte() throws FileNotFoundException {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Exposição"));
        JLabel lbl = new JLabel("Seleciona uma exposição", SwingConstants.RIGHT);
        p.add(lbl);
        p.add(getListaExposicao());
        return p;
    }

    private JComboBox getListaExposicao() {

        comboBoxExposicao = new JComboBox();
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));

        return comboBoxExposicao;
    }

    private JPanel criarPainelDescricao() {
        JPanel painel = new JPanel(new FlowLayout());

        txtDescricao = new JTextArea();
        txtDescricao.setPreferredSize(new Dimension(359, 250));
        txtDescricao.setBorder(new TitledBorder("Descrição"));
        txtDescricao.requestFocus();

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.add(txtDescricao);
        return painel;
    }

    private JPanel criarPainelSul() {

        JPanel p = new JPanel(new FlowLayout());

        p.setBorder(new TitledBorder("Opção"));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());
        p.add(criarBotaoLimpar());

        return p;
    }

    private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        listaCompletaRecurso = new JList();
        listaRecurso = new RegistoRecursos();
        modeloListaRecurso = new ModeloListaRecursos(listaRecurso);

        p.add(criarPainelListaRecurso("Lista de Recurso",
                listaCompletaRecurso,
                modeloListaRecurso, criarBotaoAdicionarRecurso()));

        p.add(criarPainelDescricao("Descrição ", txtDescricao));

        return p;
    }

    private JPanel criarPainelDescricao(
            String tituloDescrição,
            JTextArea descricao
    ) {
        JLabel lblTitulo = new JLabel(tituloDescrição, JLabel.LEFT);

        JScrollPane scrPane = new JScrollPane(txtDescricao);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaRecurso(
            String tituloLista,
            JList lstLista,
            ModeloListaRecursos modeloLista,
            JButton btnAdicionar) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(btnAdicionar);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(btn1);

        return p;
    }

    private JButton criarBotaoAdicionarRecurso() {
        btnAdicionarRecurso = new JButton("Adicionar Recurso");
//        btnAdicionarRecurso.setVisible(true);

        //btnAdicionarRecurso.setEnabled(listaRecurso.tamanho() != 0);
        btnAdicionarRecurso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Recurso[] opcoes = new Recurso[listaRecurso.getArray().length];
                    Recurso recurso = (Recurso) JOptionPane.showInputDialog(
                            DefinirDemonstracaoUI.this,
                            "Escolha um recurso", null,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]);
                    if (recurso != null) {
                        String[] opcoes2 = {"Sim", "Não"};
                        int resposta = JOptionPane.showOptionDialog(
                                DefinirDemonstracaoUI.this,
                                "Adicionar\n" + recurso.toString(),
                                "Adicionar Recurso",
                                0,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcoes2,
                                opcoes2[1]);
                        final int SIM = 0;
                        if (resposta == SIM) {

                            modeloListaRecurso.addElement((Recurso) listaCompletaRecurso.getSelectedValue());
                            listaCompletaRecurso.clearSelection();

                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {

                    JOptionPane.showMessageDialog(DefinirDemonstracaoUI.this, "Lista de recurso vazia", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            }

        });

        return btnAdicionarRecurso;
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        return btnConfirmar;
    }

    private JButton criarBotaoCancelar() {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btnCancelar;
    }

    private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                txtDescricao.setText(null);

            }
        });
        return btn;

    }
}
