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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.DefinirFAEController;
import lapr.project.model.*;

import lapr.project.utils.Utils;

/**
 *
 * @author Edu
 */
public class DefinirFAEUI extends JFrame {

    private DefinirFAEUI framePai;
    private static CentroExposicoes ce;
    private static Utilizador user;
    private transient DefinirFAEController controller;
    private JList lstCompletaUtilizadores, lstUtilizadoresFAE;
    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private DefaultListModel modeloListaFAE, modeloListaUtilizadores;
    private Exposicao exposicaoselecionda;

    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();

    public DefinirFAEUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Definir FAE");

        ce = centroExposicoes;
        user = utilizador;
        controller = new DefinirFAEController(ce, user);

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

        comboBoxExposicao = Utils.criarComboExpo(controller.getExposicoes());
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                controller.selectExposicao((Exposicao) comboBoxExposicao.getSelectedItem());
                controller.setRegistoUTilizadores();
                for (int i = 0; i < controller.getRegistoUtilizadoresFAE().getListaUtilizadores().size(); i++) {

                    if (!modeloListaUtilizadores.contains(controller.getRegistoUtilizadoresFAE().getListaUtilizadores().get(i))) {
                        modeloListaUtilizadores.addElement(controller.getRegistoUtilizadoresFAE().getListaUtilizadores().get(i));

                    }

                }
                comboBoxExposicao.setEnabled(false);
            }
        });
        return comboBoxExposicao;
    }

    private JPanel criarPainelListas() {
        
        JPanel p = new JPanel(new GridLayout(1,
                2,
                20,
                0));

        lstCompletaUtilizadores = new JList();
        modeloListaUtilizadores = new DefaultListModel();
        lstCompletaUtilizadores.setModel(modeloListaUtilizadores);

        btnAdicionarUtilizador = criarBotaoAdicionarUtilizador();
        p.add(criarPainelLista("Lista de Utilizadores",
                lstCompletaUtilizadores));

        lstUtilizadoresFAE = new JList();
        modeloListaFAE = new DefaultListModel();
        lstUtilizadoresFAE.setModel(modeloListaFAE);
        btnEliminarFAE = criarBotaoEliminarFAE(lstUtilizadoresFAE);

        p.add(criarPainelListaFAE("Lista de FAE:",
                lstUtilizadoresFAE,
                btnAdicionarUtilizador, btnEliminarFAE));
        return p;
    }

    private JPanel criarPainelLista(
            String tituloLista,
            JList lstLista ) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

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
            JButton btnSuperior,
            JButton btnInferior) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

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

    private JButton criarBotaoEliminarFAE(JList lstLista) {
        JButton btn = new JButton("Eliminar FAE");
       
        btn.addActionListener((ActionEvent e) -> {

            if (lstUtilizadoresFAE.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum item a ser eleminado!", "Nenhum iten selecionado", JOptionPane.ERROR_MESSAGE);

            } else {

                int var = JOptionPane.showConfirmDialog(null, "Deseja realmente eliminar ?", "Deseja realmente eliminar ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                if (var == 0) {
                    modeloListaFAE.remove(lstUtilizadoresFAE.getSelectedIndex());
                    controller.getListaFAE().removerFAE((FAE) lstUtilizadoresFAE.getSelectedValue());
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

                for (int i = 0; i < values.length; i++) {
                    if (!modeloListaFAE.contains(values[i])) {
                        modeloListaFAE.addElement(values[i]);

                        Utilizador u = (Utilizador) values[i];

                        controller.addFAE(u);
                        controller.adicionarFAE();
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

                if (comboBoxExposicao.getSelectedIndex() == -1 && lstUtilizadoresFAE.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Deve seleciona uma exposição e adicionar um utilizador!", null, JOptionPane.WARNING_MESSAGE);
                } else if (comboBoxExposicao.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Deve seleciona uma exposição !", null, JOptionPane.WARNING_MESSAGE);
                }
                if (controller.validaMinFAE()) {

                    if (controller.registaMembroFAE()) {

                        JOptionPane.showMessageDialog(
                                null,
                                controller.getFAEString(),
                                "Novo FAE",
                                JOptionPane.INFORMATION_MESSAGE);

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "O fae já se encontra registada no sistema", "Novo FAE", JOptionPane.ERROR_MESSAGE);

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Introduza pelo menos 2 FAE", "Definir FAE", JOptionPane.ERROR_MESSAGE);
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
