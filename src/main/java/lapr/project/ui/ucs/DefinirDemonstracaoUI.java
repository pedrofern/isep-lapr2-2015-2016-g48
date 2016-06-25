/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.*;
import lapr.project.controller.*;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;

/**
 *
 * @author Edu
 */
public class DefinirDemonstracaoUI extends JFrame {

    private static CentroExposicoes ce;
    private static Utilizador user;

    private Calendar dataInicial, dataFinal;
    private JFormattedTextField campoDataInicial, campoDataFinal;
    private JButton btnConfirmar, btnCancelar, btnLimpar;
    private JComboBox comboBoxExposicao, comboBoxDemonstracao;
    private JFrame framepai;
    private JList listaCompletaDemonstracao;
    private DefaultListModel modeloListaDemonstracao;
    private JTable tableListaRecurso;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;
    private DefinirDemonstracaoController controller;

    public DefinirDemonstracaoUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Definir Demonstração");
        ce = centroExposicoes;
        user = utilizador;
        controller = new DefinirDemonstracaoController(ce, user);

        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {
        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelListas(), BorderLayout.CENTER);
        add(criarPainelSul(), BorderLayout.SOUTH);
    }

    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new FlowLayout());

        p.add(criarPainelExposicao());

        p.setBorder(new EmptyBorder(0, 10,
                0, 10));

        p.setBorder(new TitledBorder("Dados "));
        return p;
    }

    private JPanel criarPainelExposicao() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Exposição", SwingConstants.RIGHT);

        lbl.setPreferredSize(new Dimension(80, 30));

        p.setBorder(new EmptyBorder(0, 0,
                0, 0));

        p.add(lbl);
        p.add(getListaExposicao());

        return p;
    }

    private JComboBox getListaExposicao() {

        comboBoxExposicao = Utils.criarComboExpo(controller.getRegistoExposicoes());
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                controller.setExposicao((Exposicao) comboBoxExposicao.getSelectedItem());
                comboBoxExposicao.setEnabled(false);
            }
        });
        return comboBoxExposicao;
    }

    private JPanel criarPainelSul() throws FileNotFoundException {
        JPanel p = new JPanel(new GridLayout(0, 3, 0, 4));

        p.add(criarPainelDataInicial());
        p.add(criarPainelDataFinal());
        p.add(criarPainelBotoes());

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.setBorder(new TitledBorder("Periodo da Candidatura"));
        return p;

    }

    private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        listaCompletaDemonstracao = new JList();
        modeloListaDemonstracao = new DefaultListModel();
        listaCompletaDemonstracao.setModel(modeloListaDemonstracao);

//        for (int i = 0; i < controller.getListaDemonstracoesCriadas().getListaDemonstracoes().size(); i++) {
//            modeloListaDemonstracao.addElement(controller.getListaDemonstracoesCriadas());
//        }
        for (Demonstracao d : controller.getListaDemonstracoesCriadas().getListaDemonstracoes()) {

            System.out.println(d.toString());
        }
        for (Exposicao e : controller.getRegistoExposicoes().getExposicoes()) {
            for (Demonstracao d : controller.getListaDemonstracoesCriadas().getListaDemonstracoes()) {

                System.out.println(d.toString());
            }
        }

        p.add(criarPainelListaDemonstracao("Lista Demonstração", listaCompletaDemonstracao));

        return p;
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

    private JPanel criarPainelListaDemonstracao(
            String tituloLista,
            JList lstLista
    ) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnConfirmar = criarBotaoConfirmar();
        getRootPane().setDefaultButton(btnConfirmar);

        JButton btnCancelar = criarBotaoCancelar();
        JButton btnLimpar = criarBotaoLimpar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(btnConfirmar);
        p.add(btnCancelar);
        p.add(btnLimpar);

        return p;
    }

    private void setDados() {

        Data dataInicialPrimeiro = Utils.converterStringParaData(campoDataInicial.getText());
        Data dataFinalUltimo = Utils.converterStringParaData(campoDataFinal.getText());

        controller.setDemonstracao((Demonstracao) listaCompletaDemonstracao.getSelectedValue());
        controller.setPeriodoCanidatura(dataFinalUltimo, dataFinalUltimo);
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener((ActionEvent e) -> {

            String base = "__/__/____";

            if (campoDataInicial.getText().equals(base) || campoDataFinal.getText().equals(base)) {

                JOptionPane.showMessageDialog(
                        null,
                        "Tem de preencher todos os campos!",
                        "Definir Demonstração",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    controller.validaDatas(campoDataInicial.getText(), campoDataFinal.getText());
                    setDados();

                    if (!controller.validaDataFimSuperiorInicio()) {

                        JOptionPane.showMessageDialog(null, "A data fim tem de ser superior à data de início correspondente.", "Criar Exposição", JOptionPane.ERROR_MESSAGE);

                    } else if (controller.atualizaDemonstracao()) {

                        JOptionPane.showMessageDialog(
                                null,
                                controller.getListaDemonstracoesCriadas().toStringCompleto(),
                                "Definir Demonstração",
                                JOptionPane.INFORMATION_MESSAGE);

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "A demonstrações já se encontra registada no sistema", "Definir Demonstração", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Data inválida encontrada", "Criar Exposição", JOptionPane.ERROR_MESSAGE);

                }

            }

        });
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

        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                campoDataFinal.setText(null);
                campoDataInicial.setText(null);

            }
        });
        return btnLimpar;
    }
}
