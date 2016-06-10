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
import java.text.ParseException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import lapr.project.model.*;
import lapr.project.ui.*;
import lapr.project.controller.*;
import lapr.project.model.lists.*;
import lapr.project.ui.ucs.*;
import lapr.project.utils.*;

public class CriarDemonstracaoUI extends JFrame {

    private JFormattedTextField campoDataInicial, campoDataFinal;
    private JButton btnConfirmar, btnCancelar, btnAdicionarRecurso, btnEleminarRecurso;
    private JComboBox comboBoxExposicao;
    private JTextArea txtDescricao = new JTextArea();
    private JFrame framepai;
    private ModeloListaRecursos modeloListaRecurso;
    private JList listaCompletaRecurso;
    private RegistoRecursos listaRecurso;
    private Demonstracao demostracao;
    private RegistoExposicoes listaExposicoes;
    private JTable tableListaRecurso;
    private Organizador o_Organizador;
    private CentroExposicoes centroExposicoes;
    private Exposicao exposicao;
    private Recurso recurso;
    private RegistoDemonstracoes listaDemostracao;
    private CriarDemonstracaoController m_demonstracaoController;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public CriarDemonstracaoUI(CentroExposicoes ce) throws FileNotFoundException {

        super("Criar Demonstração");

        o_Organizador = new Organizador();

        centroExposicoes = ce;
        exposicao = ce.novaExposicao();
        exposicao.setTitulo("TESTE EXPOSICAO");
        ce.registaExposicao(exposicao);
        listaExposicoes = ce.getListaExposicoes();
        listaExposicoes.adicionarExposicao(exposicao);

        exposicao.setTitulo("TESTE EXPOSICAO");
        ce.registaExposicao(exposicao);
        listaExposicoes = ce.getListaExposicoes();
        listaExposicoes.adicionarExposicao(exposicao);
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_demonstracaoController = new CriarDemonstracaoController(o_Organizador, exposicao);

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
        p.add(criarPainelExposicao());
        return p;
    }

    private JPanel criarPainelExposicao() {
        JPanel p = new JPanel();

        comboBoxExposicao = Utils.criarComboExpo(listaExposicoes);
        //FcomboBoxExposicao.setEnabled(false);

        p.add(comboBoxExposicao);

        return p;
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
        btnAdicionarRecurso = criarBotaoAdicionarRecurso();
        btnEleminarRecurso = criarBotaoEliminarRecurso(listaCompletaRecurso);

        p.add(criarPainelListaRecurso("Lista de Recurso",
                listaCompletaRecurso,
                modeloListaRecurso, btnAdicionarRecurso, btnEleminarRecurso));

        p.add(criarPainelDescricao("Descrição ", txtDescricao, criarPainelDataInicial(), criarPainelDataFinal()));

        return p;
    }

    private JPanel criarPainelDescricao(
            String tituloDescrição,
            JTextArea descricao, JPanel datainicial, JPanel datafinal
    ) {
        JLabel lblTitulo = new JLabel(tituloDescrição, JLabel.LEFT);

        JScrollPane scrPane = new JScrollPane(txtDescricao);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);
        p.add(criarPainelData(datainicial, datafinal), BorderLayout.SOUTH);

        return p;
    }

    private JPanel criarPainelListaRecurso(
            String tituloLista,
            JList lstLista,
            ModeloListaRecursos modeloLista,
            JButton btnAdicionar, JButton btnEleminarRecurso) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(btnAdicionar, btnEleminarRecurso);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelData(JPanel datainicial, JPanel datafinal) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(datainicial);
        p.add(datafinal);

        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JButton criarBotaoAdicionarRecurso() {
        btnAdicionarRecurso = new JButton("Adicionar Recurso");

        btnAdicionarRecurso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    recurso = new Recurso("Recurso");
                    listaRecurso.adicionarRecurso(recurso);
                    Recurso[] opcoes = new Recurso[listaRecurso.getArray().length];
                    for (int i = 0; i < opcoes.length; i++) {

                        opcoes[i] = recurso;

                    }

                    Recurso recurso = (Recurso) JOptionPane.showInputDialog(CriarDemonstracaoUI.this,
                            "Escolha um recurso", null,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]);

                    if (recurso != null) {
                        String[] opcoes2 = {"Sim", "Não"};
                        int resposta = JOptionPane.showOptionDialog(CriarDemonstracaoUI.this,
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

                    JOptionPane.showMessageDialog(CriarDemonstracaoUI.this, "Lista de recurso vazia", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            }

        });

        return btnAdicionarRecurso;
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");

        btnConfirmar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                try {

                    String descricao = txtDescricao.getText();
                    String temaExposicao = exposicao.getTitulo();
                    String[] dataInicial = campoDataInicial.getText().split("/");
                    String[] dataFinal = campoDataFinal.getText().split("/");
                    int diainicial = Integer.parseInt(dataInicial[0]);
                    int mesinicial = Integer.parseInt(dataInicial[1]);
                    int anoinicial = Integer.parseInt(dataInicial[2]);
                    int diafinal = Integer.parseInt(dataFinal[0]);
                    int mesfinal = Integer.parseInt(dataFinal[1]);
                    int anofinal = Integer.parseInt(dataFinal[2]);

                    Data dataInicialPrimeiro = new Data(diainicial, mesinicial, anoinicial);
                    Data dataFinalUltimo = new Data(diafinal, mesfinal, anofinal);

                    demostracao = m_demonstracaoController.registaDemonstracao(descricao, temaExposicao, dataInicialPrimeiro, dataFinalUltimo);
                    if (demostracao != null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Demonstração adicionada.",
                                "Nova Demonstração",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Demonstração já registada!",
                                "Nova Demonstração",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Registar Demonstração",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        );
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
                campoDataInicial.setText(null);
                campoDataFinal.setText(null);

            }
        });
        return btn;

    }

    private JButton criarBotaoEliminarRecurso(JList lstLista) {
        btnEleminarRecurso = new JButton("Eliminar Recurso");
        btnEleminarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recurso[] opcoes = listaRecurso.getArray();
                Recurso recurso = (Recurso) JOptionPane.showInputDialog(
                        CriarDemonstracaoUI.this,
                        "Escolha um recurso:", "Eliminar Recurso",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);
                if (recurso!= null) {
                    String[] opcoes2 = {"Sim", "Não"};
                    int resposta = JOptionPane.showOptionDialog(
                            CriarDemonstracaoUI.this,
                            "Eliminar\n" + recurso.toString(),
                            "Eliminar Telefone",
                            0,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes2,
                            opcoes2[1]);
                    final int SIM = 0;
                    if (resposta == SIM) {
                        ModeloListaRecursos  modeloListaRecurso
                                = (ModeloListaRecursos) listaCompletaRecurso.getModel();
                        modeloListaRecurso.removeElement(recurso);
                        if (modeloListaRecurso.getSize() == 0) {
                            listaCompletaRecurso.setEnabled(false);
                            btnEleminarRecurso.setEnabled(false);
                          
                        }
                    }
                }

            }
        });
        return btnEleminarRecurso;
    }

    private JPanel criarPainelDataInicial() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data incial :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataInicial = new JFormattedTextField(mascara);
            campoDataInicial.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataInicial);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return painel;
    }

    private JPanel criarPainelDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataFinal = new JFormattedTextField(mascara);
            campoDataFinal.setPreferredSize(new Dimension(80, 20));

            painel.add(labelData);
            painel.add(campoDataFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return painel;
    }
}
