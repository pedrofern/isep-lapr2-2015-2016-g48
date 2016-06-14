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
import javafx.scene.layout.Region;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.CriarExposicaoController;
import lapr.project.controller.DefinirFAEController;
import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Utils;

/**
 *
 * @author Edu
 */
public class DefinirFAEUI extends JFrame {

    private DefinirFAEUI framePai;
    private static CentroExposicoes ce;
    private static Utilizador user;
    private JComboBox combo;
    private DefinirFAEController controller;
    private JList lstCompletaUtilizadores, lstUtilizadoresFAE;
    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private DefaultListModel modeloListaFAE, modeloListaUtilizadores;
    private RegistoUtilizadores listaCompletaUtilizadores;
    private RegistoExposicoes listaExposicoes;
    private ListaFAE listaUtilizadoresFAE;
    private Organizador o_Organizador;
    private int i = 0;
    private Exposicao m_exposicao;
    private Object[] tmp;
    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();

    public DefinirFAEUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Definir FAE");

        ce = centroExposicoes;
        user = utilizador;
        o_Organizador = new Organizador(user);
        controller = new DefinirFAEController(centroExposicoes, o_Organizador);
        m_exposicao = new Exposicao();
        m_exposicao.setTitulo("TESTE EXPOSICAO");

        listaExposicoes = ce.getRegistoExposicoes();
        listaExposicoes.adicionarExposicao(m_exposicao);
        listaExposicoes.registaExposicao(m_exposicao);
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
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

    private JPanel criarPainelSul() {

        JPanel p = new JPanel(new FlowLayout());

        p.setBorder(new TitledBorder("Opção"));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }

    private JPanel criarPainelExposicao() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Exposição", SwingConstants.RIGHT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        p.setBorder(new EmptyBorder(0, 0,
                0, 0));

        p.add(lbl);
        p.add(getListaExposicao());

        return p;
    }

    private JComboBox getListaExposicao() {
      
        comboBoxExposicao = Utils.criarComboExpo(listaExposicoes);
        comboBoxExposicao.setPreferredSize(new Dimension(250, 20));
        return comboBoxExposicao;
    }

    private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        lstCompletaUtilizadores = new JList();
        listaCompletaUtilizadores = ce.getRegistoUtilizadores();
        modeloListaUtilizadores = new DefaultListModel();
        //modeloListaUtilizadores = new ModeloListaUtilizadores(listaCompletaUtilizadores);
        lstCompletaUtilizadores.setModel(modeloListaUtilizadores);
        for (int i = 0; i < listaCompletaUtilizadores.getListaUtilizadores().size(); i++) {
            modeloListaUtilizadores.addElement(listaCompletaUtilizadores.getListaUtilizadores().get(i));
        }

        btnAdicionarUtilizador = criarBotaoAdicionarUtilizador();
        p.add(criarPainelLista("Lista de Utilizadores",
                lstCompletaUtilizadores,
                modeloListaUtilizadores));

        lstUtilizadoresFAE = new JList();
        listaUtilizadoresFAE = new ListaFAE();
        modeloListaFAE = new DefaultListModel();
        lstUtilizadoresFAE.setModel(modeloListaFAE);
        btnEliminarFAE = criarBotaoEliminarJogador(lstUtilizadoresFAE);

        p.add(criarPainelListaFAE("Lista de FAE:",
                lstUtilizadoresFAE,
                modeloListaFAE,
                btnAdicionarUtilizador, btnEliminarFAE));
        return p;
    }

    private JPanel criarPainelLista(
            String tituloLista,
            JList lstLista,
            DefaultListModel modelolista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        //lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaFAE(
            String tituloLista,
            JList lstLista,
            DefaultListModel modeloLista,
            JButton btnSuperior,
            JButton btnInferior) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        //lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(btnSuperior, btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JButton criarBotaoEliminarJogador(JList lstLista) {
        JButton btn = new JButton("Eliminar FAE");
        Object[] lista = lstUtilizadoresFAE.getSelectedValues();
        btn.addActionListener((ActionEvent e) -> {

            if (lstUtilizadoresFAE.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum item a ser eleminado!", "Nenhum iten selecionado", JOptionPane.ERROR_MESSAGE);

            } else {

                int var = JOptionPane.showConfirmDialog(null, "Deseja realmente eleminar ?", "Deseja realmente eleminar ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                if (var == 0) {
                    modeloListaFAE.remove(lstUtilizadoresFAE.getSelectedIndex());
                    int index = lstUtilizadoresFAE.getSelectedIndex();
                    if (modeloListaFAE.getSize() == 0) {
                        btn.setEnabled(true);

                    } else if (lstUtilizadoresFAE.getSelectedIndex() == modeloListaFAE.getSize()) {
                        --index;
                    } else {
                        lstUtilizadoresFAE.setSelectedIndex(index);
                        lstUtilizadoresFAE.ensureIndexIsVisible(index);
                    }
                }
            }
        });
        return btn;
    }

    private JButton criarBotaoAdicionarUtilizador() {

        btnAdicionarUtilizador = new JButton("Adicionar Utilizador");
        btnAdicionarUtilizador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Object[] values = lstCompletaUtilizadores.getSelectedValues();
                for (Object valor : values) {
                    if (!modeloListaFAE.contains(valor)) {
                        modeloListaFAE.addElement(valor);
                        tmp[i] = valor;
                        i++;

                    } else {
                        JOptionPane.showMessageDialog(
                                framePai,
                                "FAE já incluído na lista de FAE!",
                                "Novo FAE",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }

            }
        });

        return btnAdicionarUtilizador;
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Exposicao exp = new Exposicao();
                exp.setTitulo("TEste");
                Utilizador u = (Utilizador) tmp[i];

                if (controller.registaMenbroFAE(controller.getFAE())) {

                    m_exposicao.getListaFAE();
                    controller.addFAE(u, exp);
                    JOptionPane.showMessageDialog(
                            null,
                            controller.getFAEString(),
                            "Novo FAE",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "FAE já adicionado!",
                            "Novo FAE",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        return btnConfirmar;
    }

    private JButton criarBotaoCancelar() {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        return btnCancelar;
    }
}
