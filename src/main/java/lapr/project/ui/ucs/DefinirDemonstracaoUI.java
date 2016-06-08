package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import lapr.project.controller.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.utils.*;
import lapr.project.model.*;
import lapr.project.ui.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirDemonstracaoUI extends JFrame {

    private JButton btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private JTextField txtCodigo;
    private JTextArea txtDescricao;
    private JFrame framepai;
    private JList listProduto = new JList();
    private JScrollPane scroListaRecurso = new JScrollPane(listProduto);
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
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelCentro(), BorderLayout.CENTER);
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

    private JPanel criarPainelOeste() {
        JPanel painel = new JPanel(new GridLayout(0, 1));

        final int CAMPO_LARGURA = 30;
        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension(500, 100));
        txtCodigo.setBorder(new TitledBorder("Código/ID"));
        txtCodigo.requestFocus();

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 1000;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        painel.setBorder(new TitledBorder("Dados Demonstração"));
        painel.add(txtCodigo);
        painel.add(criarPainelRecurso());

        return painel;

    }

    private JScrollPane criarPainelRecurso() {
        JPanel painel = new JPanel(new GridLayout(0, 1, 0, 0));
        scroListaRecurso.setBorder(new TitledBorder("Lista Produto"));
        scroListaRecurso.setPreferredSize(new Dimension(140, 205));
        painel.add(scroListaRecurso, BorderLayout.NORTH);

        return scroListaRecurso;
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

    private JPanel criarPainelCentro() {

        JPanel painel = new JPanel(new FlowLayout());

        painel.add(criarPainelDescricao());

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

    private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                txtCodigo.setText(null);
                txtDescricao.setText(null);

            }
        });
        return btn;
    }

//    private CentroExposicoes m_centroDeExposicoes;
//    private DefinirDemonstracaoController m_controller;
//
//    public DefinirDemonstracaoUI(CentroExposicoes centroDeExposicoes) {
//        m_centroDeExposicoes = centroDeExposicoes;
//        m_controller = new DefinirDemonstracaoController(m_centroDeExposicoes);
//    }
//
//    @Override
//    public void run() {
//
//        String strCodigoUnico = Utils.readLineFromConsole("Introduza o código único da demonstração: ");
//        m_controller.setCodigoUnico(strCodigoUnico);
//
//        String strDescricao = Utils.readLineFromConsole("Introduza a descrição da demonstração: ");
//        m_controller.setDescricao(strDescricao);
//
//        apresentaDemonstracao(m_controller.getDemonstracao());
//
//        if (Utils.confirma("Confirma?")) {
//            m_controller.registaDemonstracao();
//        }
//    }
//
//    private void apresentaDemonstracao(Demonstracao demonstracao) {
//        if (demonstracao == null) {
//            System.out.println("Demonstração não registada.");
//        } else {
//            System.out.println(demonstracao.toString());
//        }
//    }
}
