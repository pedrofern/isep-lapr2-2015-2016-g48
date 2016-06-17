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
    private DefinirFAEController controller;
    private JList lstCompletaUtilizadores, lstUtilizadoresFAE;
    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private static JComboBox comboBoxExposicao;
    private DefaultListModel modeloListaFAE, modeloListaUtilizadores;
    private RegistoUtilizadores listaCompletaUtilizadores;
    private RegistoExposicoes listaExposicoes;
    private ListaFAE listaUtilizadoresFAE;
    private Organizador o_Organizador;
    private ListaOrganizadores listaOrganizadores;
    private Exposicao exposicaoselecionda;

    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();

    public DefinirFAEUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Definir FAE");

        ce = centroExposicoes;
        user = utilizador;
        controller = new DefinirFAEController(centroExposicoes, user);
        listaCompletaUtilizadores = controller.getRegistoUTilizadores();

        listaExposicoes = ce.getRegistoExposicoes();
        listaUtilizadoresFAE = controller.getListaFAE();

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
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int tmp = comboBoxExposicao.getSelectedIndex();
                controller.selectExposicao((Exposicao)comboBoxExposicao.getSelectedItem());
                    comboBoxExposicao.setEnabled(false);
            }
        });
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
        modeloListaUtilizadores = new DefaultListModel();
        lstCompletaUtilizadores.setModel(modeloListaUtilizadores);
        for (int i = 0; i < listaCompletaUtilizadores.getListaUtilizadores().size(); i++) {

                modeloListaUtilizadores.addElement(listaCompletaUtilizadores.getListaUtilizadores().get(i));

            
        }

        btnAdicionarUtilizador = criarBotaoAdicionarUtilizador();
        p.add(criarPainelLista("Lista de Utilizadores",
                lstCompletaUtilizadores,
                modeloListaUtilizadores));

        lstUtilizadoresFAE = new JList();
        modeloListaFAE = new DefaultListModel();
        lstUtilizadoresFAE.setModel(modeloListaFAE);
        btnEliminarFAE = criarBotaoEliminarRecurso(lstUtilizadoresFAE);

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

    private JButton criarBotaoEliminarRecurso(JList lstLista) {
        JButton btn = new JButton("Eliminar FAE");
        Object[] lista = lstUtilizadoresFAE.getSelectedValues();
        btn.addActionListener((ActionEvent e) -> {

            if (lstUtilizadoresFAE.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum item a ser eleminado!", "Nenhum iten selecionado", JOptionPane.ERROR_MESSAGE);

            } else {

                int var = JOptionPane.showConfirmDialog(null, "Deseja realmente eliminar ?", "Deseja realmente eliminar ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                if (var == 0) {
                    modeloListaFAE.remove(lstUtilizadoresFAE.getSelectedIndex());
                    controller.getListaFAE().removerFAE((FAE)lstUtilizadoresFAE.getSelectedValue());
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

                        controller.criarFAE(u);

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
                } else {

                     
                   controller.adicionarFAE();
                    if (controller.registaEstado()) {

                        JOptionPane.showMessageDialog(
                                null,
                                controller.getFAEString(),
                                "Novo FAE",
                                JOptionPane.INFORMATION_MESSAGE);

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "O fae já se encontra registada no sistema", "Novo FAE", JOptionPane.ERROR_MESSAGE);

                    }
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
