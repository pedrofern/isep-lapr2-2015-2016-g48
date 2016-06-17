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
import lapr.project.controller.*;
import lapr.project.model.lists.*;
import lapr.project.utils.*;

public class ListarCandidaturaRetiradaUI extends JFrame {

    private CentroExposicoes ce;
    private RegistoExposicoes listaExposicoes;
    private JButton btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private JFrame framepai;
    private DefaultListModel modeloLisCandidaturaExposicao;
    private JList listaCompletaCandidaturaRetiradaExposicao;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public ListarCandidaturaRetiradaUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Listar Candidaturas Demonstração");
        ce = centroExposicoes;
        listaExposicoes = ce.getRegistoExposicoes();
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelListas(), BorderLayout.CENTER);
        add(criarPainelSul(), BorderLayout.SOUTH);
    }

    private JPanel criarPainelNorte() throws FileNotFoundException {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Exposição"));
        JLabel lbl = new JLabel("Seleciona uma exposição", SwingConstants.RIGHT);
        p.add(lbl);
        p.add(criarPainelExposicao());
        return p;
    }

    private JComboBox criarPainelExposicao() {

        comboBoxExposicao = Utils.criarComboExpo(listaExposicoes);
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int tmp = comboBoxExposicao.getSelectedIndex();

                if (comboBoxExposicao.getSelectedIndex() >= 0) {
                    comboBoxExposicao.setEnabled(false);
                } else {

                    comboBoxExposicao.setEnabled(true);
                }

            }
        });
        return comboBoxExposicao;

    }

    private JPanel criarPainelSul() {

        JPanel p = new JPanel(new FlowLayout());

        p.setBorder(new TitledBorder("Opção"));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }

    private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        listaCompletaCandidaturaRetiradaExposicao = new JList();
        modeloLisCandidaturaExposicao = new DefaultListModel();
        listaCompletaCandidaturaRetiradaExposicao.setModel(modeloLisCandidaturaExposicao);

        p.add(criarPainelLista("Lista de Candidaturas Retirada",
                listaCompletaCandidaturaRetiradaExposicao,
                modeloLisCandidaturaExposicao));

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

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");

        btnConfirmar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
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

}
