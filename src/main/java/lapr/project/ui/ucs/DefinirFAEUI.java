package lapr.project.ui.ucs;

import java.io.FileNotFoundException;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Eduangelo Ferreira Nº aluno: 1151094
 */
public class DefinirFAEUI extends JFrame {

    private JList lstCompletaUtilizadores, lstUtilizadoresFAE;
    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private ModeloListaUtilizadores modeloListaUtilizadores;
    private ModeloListaUtilizadores modeloListaFAE;
    private ListaUtilizadores listaCompletaUtilizadores;
    private ListaUtilizadores listaUtilizadoresFAE;
    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();

    public DefinirFAEUI() throws FileNotFoundException {

        super("Definir FAE");

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

        comboBoxExposicao = new JComboBox();
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
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
        listaCompletaUtilizadores = new ListaUtilizadores();
        modeloListaUtilizadores = new ModeloListaUtilizadores(listaCompletaUtilizadores);
        btnAdicionarUtilizador = criarBotaoAdicionarUtilizador();
        p.add(criarPainelLista("Lista de Utilizadores",
                lstCompletaUtilizadores,
                modeloListaUtilizadores));

        lstUtilizadoresFAE = new JList();
        listaUtilizadoresFAE = new ListaUtilizadores();
        modeloListaFAE = new ModeloListaUtilizadores(listaUtilizadoresFAE);
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
            ModeloListaUtilizadores modeloLista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20,20,20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaFAE(
            String tituloLista,
            JList lstLista,
            ModeloListaUtilizadores modeloLista,
            JButton btnSuperior,
            JButton btnInferior) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20,20,20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(btnSuperior, btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JButton criarBotaoEliminarJogador(JList lstLista) {
        JButton btn = new JButton("Eliminar FAE");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloListaUtilizadores modelo = (ModeloListaUtilizadores) lstLista.getModel();
                modelo.removeElement((Utilizador) lstLista.getSelectedValue());

            }
        });
        return btn;
    }

    private JButton criarBotaoAdicionarUtilizador() {
        btnAdicionarUtilizador = new JButton("Adicionar Utilizador");
        btnAdicionarUtilizador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloListaFAE.addElement((Utilizador) lstCompletaUtilizadores.getSelectedValue());
                lstCompletaUtilizadores.clearSelection();

            }
        });
        return btnAdicionarUtilizador;
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

}
