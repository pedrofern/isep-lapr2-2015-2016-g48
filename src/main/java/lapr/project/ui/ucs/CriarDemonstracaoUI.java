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

public class CriarDemonstracaoUI extends JFrame {

    private ListaRecursoDemonstracao listarecurosdemonstracao;
    private JButton btnConfirmar, btnCancelar, btnAdicionarRecurso, btnEleminarRecurso;
    private JComboBox comboBoxExposicao;
    private JTextArea txtDescricao;
    private JFrame framepai;
    private DefaultListModel modeloListaRecurso;
    private JList listaCompletaRecurso;
    private RegistoRecursos listaRecurso;
    private Demonstracao demostracao;
    private RegistoExposicoes listaExposicoes;
    private Organizador o_Organizador;
    private static CentroExposicoes ce;
    private static Utilizador user;
    private Exposicao exposicao, exposicaoseleccionada;
    private Recurso recurso;
    private ListaDemonstracoes listaDemostracao;
    private CriarDemonstracaoController m_demonstracaoController;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public CriarDemonstracaoUI(CentroExposicoes centroExposicoes, Utilizador utilizador) throws FileNotFoundException {

        super("Criar Demonstração");
        user = utilizador;
        ce = centroExposicoes;
        o_Organizador = new Organizador(utilizador);
        m_demonstracaoController = new CriarDemonstracaoController(o_Organizador, ce);
        demostracao = m_demonstracaoController.novaDemonstracao();
        listarecurosdemonstracao = demostracao.getListaRecursosDemonstracao();

        listaExposicoes = ce.getRegistoExposicoes();

        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    private JComboBox criarPainelExposicao() {

        comboBoxExposicao = Utils.criarComboExpo(listaExposicoes);
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int tmp = comboBoxExposicao.getSelectedIndex();
                exposicaoseleccionada = listaExposicoes.getExposicoes().get(tmp);
                m_demonstracaoController.selectExposicao(listaExposicoes.getExposicoes().get(tmp));
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
        modeloListaRecurso = new DefaultListModel();
        listaCompletaRecurso.setModel(modeloListaRecurso);
        btnAdicionarRecurso = criarBotaoAdicionarRecurso();
        btnEleminarRecurso = criarBotaoEliminarRecurso(listaCompletaRecurso);

        p.add(criarPainelListaRecurso("Lista de Recurso",
                listaCompletaRecurso,
                modeloListaRecurso, btnAdicionarRecurso, btnEleminarRecurso));

        p.add(criarPainelDescricao("Descrição ", txtDescricao));

        return p;
    }

    private JPanel criarPainelDescricao(
            String tituloDescrição,
            JTextArea descricao
    ) {
        JLabel lblTitulo = new JLabel(tituloDescrição, JLabel.LEFT);
        txtDescricao = new JTextArea();
        txtDescricao.setPreferredSize(new Dimension(359, 250));
        txtDescricao.requestFocus();
        JScrollPane scrPane = new JScrollPane(txtDescricao);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaRecurso(
            String tituloLista,
            JList lstLista,
            DefaultListModel modeloLista,
            JButton btnAdicionar, JButton btnEleminarRecurso) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

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

                listaRecurso = m_demonstracaoController.getListaRecursos();
                Recurso[] opcoes = new Recurso[listaRecurso.getArray().length];
                for (int i = 0; i < opcoes.length; i++) {
                    opcoes[i] = listaRecurso.getListaRecursos().get(i);
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
                        if (!modeloListaRecurso.contains(recurso)) {
                            modeloListaRecurso.addElement(recurso);
                            listarecurosdemonstracao = m_demonstracaoController.getListaRecursosDemonstracao();
                            listarecurosdemonstracao.valida((recurso));

                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Recurso já incluído na lista de Recurso!",
                                    "Novo Recurso",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    }

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
                    if ((txtDescricao.getText().trim().isEmpty() == true) && listaCompletaRecurso.getSize() == null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Tem de preencher todos os campos!",
                                "Criar Demonstração",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    demostracao = m_demonstracaoController.registaDemonstracao(txtDescricao.getText(), exposicaoseleccionada.getTitulo());
                    m_demonstracaoController.setListaRecurso(listaRecurso);

                    boolean adicionarNovaDemonstracao = m_demonstracaoController.valida();
                    if (adicionarNovaDemonstracao == true) {
                        if (demostracao == null) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Demonstração já criada",
                                    "Nova Demonstração",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        JOptionPane.showMessageDialog(
                                null,
                                "Demonstração adicionada: \n"
                                + m_demonstracaoController.getDemonstraçãoString(),
                                "Nova Demonstração",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "O registo não é válido!\nVerifique todos os campos",
                                "Nova Demonstração",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Criar Demonstração",
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

            }
        });
        return btn;

    }

    private JButton criarBotaoEliminarRecurso(JList lstLista) {
        btnEleminarRecurso = new JButton("Eliminar Recurso");
        btnEleminarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaCompletaRecurso.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum recurso a ser eleminado!", "Nenhum recurso selecionado", JOptionPane.ERROR_MESSAGE);

                } else {

                    int var = JOptionPane.showConfirmDialog(null, "Deseja realmente eliminar ?", "Deseja realmente eliminar ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (var == 0) {
                        listarecurosdemonstracao.removerRecurso((Recurso) listaCompletaRecurso.getSelectedValue());
                        modeloListaRecurso.remove(listaCompletaRecurso.getSelectedIndex());
                        int index = listaCompletaRecurso.getSelectedIndex();
                        if (modeloListaRecurso.getSize() == 0) {
                            btnEleminarRecurso.setEnabled(true);

                        } else if (listaCompletaRecurso.getSelectedIndex() == modeloListaRecurso.getSize()) {
                            --index;
                        } else {
                            listaCompletaRecurso.setSelectedIndex(index);
                            listaCompletaRecurso.ensureIndexIsVisible(index);
                        }
                    }
                }

            }
        });
        return btnEleminarRecurso;
    }

    public JList getLstRecurso() {
        return listaCompletaRecurso;
    }

    public JButton getBotaoRemoverRecurso() {
        return btnEleminarRecurso;
    }

}
