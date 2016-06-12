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
    private JList listaCompletaExposicao, listaCompletaDemonstracao;
    private ModeloListaDemonstracoes modeloListaDemonstracao;
    private ModeloListaExposicao modeloListaExposicao;
    private JTable tableListaRecurso;
    private ListaDemonstracoes listaDemonstracao;
    private RegistoExposicoes listaExposicao;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public DefinirDemonstracaoUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Definir Demonstração");
        ce=centroExposicoes;
        user=utilizador;

        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelListas(), BorderLayout.CENTER);
        add(criarPainelSul(),BorderLayout.SOUTH);
    }

    private JPanel criarPainelSul() throws FileNotFoundException {
        JPanel p = new JPanel(new GridLayout(0, 3,0,4));

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

        listaCompletaExposicao = new JList();
        listaExposicao = new RegistoExposicoes();
        modeloListaExposicao = new ModeloListaExposicao(listaExposicao);

        p.add(criarPainelListaExposicao("Lista Exposição",
                listaCompletaExposicao,
                modeloListaExposicao));

        listaCompletaDemonstracao = new JList();
        listaDemonstracao = new ListaDemonstracoes();
        modeloListaDemonstracao = new ModeloListaDemonstracoes(listaDemonstracao);
        p.add(criarPainelListaDemonstracao("Lista Demonstração", listaCompletaDemonstracao, modeloListaDemonstracao));

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

    private JPanel criarPainelListaExposicao(
            String tituloLista,
            JList lstLista,
            ModeloListaExposicao modeloLista) {

        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaDemonstracao(
            String tituloLista,
            JList lstLista,
            ModeloListaDemonstracoes modeloLista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
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
