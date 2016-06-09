package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.ui.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoUI extends JFrame {

    private CentroExposicoes m_centroDeExposicoes;
    private CriarExposicaoController m_controller;
    private static final int JANELA_LARGURA = 1000;
    private static final int JANELA_ALTURA = 500;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Criar Exposicao").getPreferredSize();
    private JButton btnConfirmar, btnFechar;
    private JTextField txtTitulo,txtDescricao,txtDataInicio,txtDataFim,txtLocal;


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

//    private void novaExposicao() {
//        m_controller.novaExposicao();
//    }
    public void criarComponentes() {
        
        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelCentro(), BorderLayout.CENTER);
    }

    
    
    private JPanel criarPainelCentro(){
        JPanel p = new JPanel(new FlowLayout());
        p.add(criarPainelTitulo());
        p.add(criarPainelDescricao());
        p.add(criarPainelDataInicio());
        p.add(criarPainelDataInicio());
        p.add(criarPainelLocal());
        p.setPreferredSize(new Dimension(200, 50));
        return p;
    }
    
    private JPanel criarPainelTitulo(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Titulo:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtTitulo = new JTextField(CAMPO_LARGURA);
        txtTitulo.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtTitulo);
        return p;
    }
    
    private JPanel criarPainelLocal(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Local:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtLocal = new JTextField(CAMPO_LARGURA);
        txtLocal.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtLocal);
        return p;
    }
    
    private JPanel criarPainelDescricao(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Descrição:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtDescricao = new JTextField(CAMPO_LARGURA);
        txtDescricao.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtDescricao);

        return p;

    }
    
    private JPanel criarPainelDataInicio(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Data Inicio:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtDataInicio = new JTextField(CAMPO_LARGURA);
        txtDataInicio.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtDataInicio);        
        return p;
    }
    
    private JPanel criarPainelDataFim(){
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Data Fim:", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);
        final int CAMPO_LARGURA = 30;
        txtDataFim = new JTextField(CAMPO_LARGURA);
        txtDataFim.requestFocus();
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(txtDataFim);        
        return p;
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

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
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

    private Exposicao introduzDadosExposicao() {
        String strTitulo = Utils.readLineFromConsole("Introduza Titulo: ");
        m_controller.setTitulo(strTitulo);

        String strDescricao = Utils.readLineFromConsole("Introduza Descricao: ");
        m_controller.setDescricao(strDescricao);

        String strLocal = Utils.readLineFromConsole("Introduza Local: ");
        m_controller.setLocal(strLocal);

        Date dtInicio = Utils.readDateFromConsole("Introduza Data Inicio: ");
        m_controller.setDataInicio(dtInicio);

        Date dtFim = Utils.readDateFromConsole("Introduza Data Fim: ");
        m_controller.setDataFim(dtFim);

        Date dtInicioSubmissao = Utils.readDateFromConsole("Introduza Data Inicio Submissao: ");
        m_controller.setDataInicioSubmissao(dtInicioSubmissao);

        Date dtFimSubmissao = Utils.readDateFromConsole("Introduza Data Fim Submissao: ");
        m_controller.setDataFimSubmissao(dtFimSubmissao);

        Date dtInicioAtribuicao = Utils.readDateFromConsole("Introduza Data Inicio Atribuicao: ");
        m_controller.setDataInicioAtribuicao(dtInicioAtribuicao);

        while (Utils.confirma("Pretende inserir orgaizador (s/n)?")) {
            String strOrg = Utils.readLineFromConsole("Introduza ID Organizador: ");
            m_controller.addOrganizador(strOrg);
        }

        apresentaExposicao(m_controller.getExposicao());

        if (Utils.confirma("Confirma?")) {
            return m_controller.registaExposicao();
        }
        return null;
    }

    private void apresentaExposicao(Exposicao exposicao) {
        if (exposicao == null) {
            System.out.println("Exposicao não registada.");
        } else {
            System.out.println(exposicao.toString());
        }
    }
}
