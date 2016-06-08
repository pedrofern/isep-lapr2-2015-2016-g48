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
    private JScrollPane scrollPaneListaRecurso;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();

    public DefinirDemonstracaoUI() throws FileNotFoundException {

        super("Criar Demonstração");
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelRecurso(), BorderLayout.CENTER);
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

        painel.add(criarPainelID());
        painel.add(criarPainelDescricao());
        return painel;
    }

    private JPanel criarPainelID() {

        JPanel painel = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Código/ID", SwingConstants.RIGHT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 30;
        txtCodigo = new JTextField(CAMPO_LARGURA);
        txtCodigo.requestFocus();

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;

        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.add(lbl);
        painel.add(txtCodigo);

        return painel;
    }

    private JScrollPane criarPainelRecurso() {
        JPanel painel = new JPanel(new GridLayout(0, 1, 0, 0));
        scrollPaneListaRecurso = new JScrollPane(painel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneListaRecurso.setPreferredSize(new Dimension(140, 305));
        scrollPaneListaRecurso.setBorder(new TitledBorder("Lista Recurso"));

        return scrollPaneListaRecurso;
    }

    private JPanel criarPainelDescricao() {
        JPanel painel = new JPanel(new FlowLayout());

        txtDescricao = new JTextArea();
        txtDescricao.setPreferredSize(new Dimension(300, 100));
        txtDescricao.setBorder(new TitledBorder("Descrição"));
        txtDescricao.requestFocus();

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.add(txtDescricao);
        return painel;
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
