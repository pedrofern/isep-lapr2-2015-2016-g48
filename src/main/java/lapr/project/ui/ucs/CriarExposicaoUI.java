package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import lapr.project.ui.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoUI extends JFrame {

    private JFormattedTextField campoDataInicial, campoDataFinal, campoSubCandDataInicial, campoSubCandDataFinal, campoSubStandsDatainicial, campoSubStandsDataFinal, campoDataAlterarConflito;
    private CentroExposicoes m_centroDeExposicoes;
    private CriarExposicaoController m_controller;
    private static final int JANELA_LARGURA = 700;
    private static final int JANELA_ALTURA = 300;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Criar Exposicao").getPreferredSize();
    private JButton btnConfirmar, btnFechar;
    private JTextField txtTitulo, txtDescricao, txtDataInicio, txtDataFim, txtLocal;

    public CriarExposicaoUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controller = new CriarExposicaoController(m_centroDeExposicoes);

    }

    public CriarExposicaoUI() {
        super("Criar Exposicao");
        criarComponentes();
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    public void criarComponentes() {

        //add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelOeste(), BorderLayout.WEST);
    }

    private JPanel criarPainelOeste() {
        JPanel p = new JPanel(new GridLayout(0, 1));
        p.add(criarPainelTitulo());
        p.add(criarPainelDescricao());
        p.add(criarPainelLocal());
        p.add(criarPainelExposicaoData(criarPainelExposiçãoDataInicial(), criarPainelExposiçãoDataFinal()));

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.setBorder(new TitledBorder("Dados"));
        return p;
    }

    private JPanel criarPainelTitulo() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Titulo:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtTitulo = new JTextField(CAMPO_LARGURA);
        txtTitulo.requestFocus();
        txtTitulo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev) {
                txtTitulo.setText(txtTitulo.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtTitulo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtTitulo.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        });
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtTitulo);
        return p;
    }

    private JPanel criarPainelLocal() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Local:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtLocal = new JTextField(CAMPO_LARGURA);
        txtLocal.requestFocus();
        txtLocal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev) {
                txtLocal.setText(txtLocal.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtLocal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtLocal.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        });
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtLocal);
        return p;
    }

    private JPanel criarPainelDescricao() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Descrição:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtDescricao = new JTextField(CAMPO_LARGURA);
        txtDescricao.requestFocus();
        txtDescricao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev) {
                txtDescricao.setText(txtDescricao.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtDescricao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtDescricao.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        });
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtDescricao);

        return p;

    }

    private JPanel criarPainelExposicaoData(JPanel datainicial, JPanel datafinal) {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel painel = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));
        painel.add(datainicial);
        painel.add(datafinal);

        return painel;

    }

    private JPanel criarPainelPeriodo() {
        JPanel painel = new JPanel(new GridLayout(0, 1));

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        painel.setBorder(new TitledBorder("Periodo: "));
                
        return painel;

    }

    private JPanel criarPainelExposiçãoDataInicial() {
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

    private JPanel criarPainelExposiçãoDataFinal() {
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

    private JPanel criarPainelCandidaturaDataInicial() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data incial :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubCandDataInicial = new JFormattedTextField(mascara);
            campoSubCandDataInicial.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubCandDataInicial);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return painel;
    }

    private JPanel criarPainelCandidaturaDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubCandDataFinal = new JFormattedTextField(mascara);
            campoSubCandDataFinal.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubCandDataFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return painel;
    }

    private JPanel criarPainelStandsDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubStandsDatainicial = new JFormattedTextField(mascara);
            campoSubStandsDataFinal.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubStandsDataFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return painel;
    }

    private JPanel criarPainelConflitoDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataAlterarConflito = new JFormattedTextField(mascara);
            campoDataAlterarConflito.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataAlterarConflito);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return painel;
    }

    private JPanel criarPainelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBotoes());
        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoConfirmar();
        getRootPane().setDefaultButton(btnOK);
        JButton btnClose = criarBotaoFechar();
        JPanel p = new JPanel();
        p.add(btnOK);
        p.add(btnClose);
        return p;

    }

    private void guardar() {

        String[] dataInicial = campoDataInicial.getText().split("/");
        String[] dataFinal = campoDataFinal.getText().split("/");
        int diainicial = Integer.parseInt(dataInicial[0]);
        int mesinicial = Integer.parseInt(dataInicial[1]);
        int anoinicial = Integer.parseInt(dataInicial[2]);
        int diafinal = Integer.parseInt(dataFinal[0]);
        int mesfinal = Integer.parseInt(dataFinal[1]);
        int anofinal = Integer.parseInt(dataFinal[2]);
        Data dataInicialPrimeiro = new Data(diainicial, mesinicial, anoinicial);
        Data dataFinalUltimo = new Data(diafinal, mesfinal, anofinal);
        m_controller.novaExposicao();
        m_controller.criaExposicao(txtTitulo.getText(), txtDescricao.getText(), txtLocal.getText(), dataInicialPrimeiro, dataFinalUltimo);
//        JOptionPane.showMessageDialog(
//                            null,
//                            "Nova Exposição: \n"
//                                    +"\nTitulo: "+titulo
//                                    +"\nDescricao: "+descricao
//                                    +"\Local: "+local
//                                    +"\nData Inicio: "+dataInicio
//                                    +"\nData Fim: "+dataFim,
//                            "Nova Exposição",
//                            JOptionPane.INFORMATION_MESSAGE);    
        dispose();

    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTitulo.getText().isEmpty() == true
                        || txtDescricao.getText().isEmpty() == true
                        || txtLocal.getText().isEmpty() == true) {
//                        JOptionPane.showMessageDialog(
//                            null,
//                            "Tem de preencher todos os campos!",
//                            "Criar Exposoção",
//                            JOptionPane.ERROR_MESSAGE);                        
                } else {
                    guardar();
                }
            }
        });
        return btnConfirmar;
    }

    private JButton criarBotaoFechar() {
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btnFechar;
    }

//    private Exposicao introduzDadosExposicao() {
//        String strTitulo = Utils.readLineFromConsole("Introduza Titulo: ");
//        m_controller.setTitulo(strTitulo);
//
//        String strDescricao = Utils.readLineFromConsole("Introduza Descricao: ");
//        m_controller.setDescricao(strDescricao);
//
//        String strLocal = Utils.readLineFromConsole("Introduza Local: ");
//        m_controller.setLocal(strLocal);
//
//        Data dtInicio = Utils.readDateFromConsole("Introduza Data Inicio: ");
//        m_controller.setDataInicio(dtInicio);
//
//        Data dtFim = Utils.readDateFromConsole("Introduza Data Fim: ");
//        m_controller.setDataFim(dtFim);
//
//        Data dtInicioSubmissao = Utils.readDateFromConsole("Introduza Data Inicio Submissao: ");
//        m_controller.setDataInicioSubmissao(dtInicioSubmissao);
//
//        Data dtFimSubmissao = Utils.readDateFromConsole("Introduza Data Fim Submissao: ");
//        m_controller.setDataFimSubmissao(dtFimSubmissao);
//
//        Data dtInicioAtribuicao = Utils.readDateFromConsole("Introduza Data Inicio Atribuicao: ");
//        m_controller.setDataInicioAtribuicao(dtInicioAtribuicao);
//
//        while (Utils.confirma("Pretende inserir orgaizador (s/n)?")) {
//            String strOrg = Utils.readLineFromConsole("Introduza ID Organizador: ");
//            m_controller.addOrganizador(strOrg);
//        }
//
//        apresentaExposicao(m_controller.getExposicao());
//
//        if (Utils.confirma("Confirma?")) {
//            return m_controller.registaExposicao();
//        }
//        return null;
//    }
//    private void apresentaExposicao(Exposicao exposicao) {
//        if (exposicao == null) {
//            System.out.println("Exposicao não registada.");
//        } else {
//            System.out.println(exposicao.toString());
//        }
//    }
}
