/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.DecidirCandidaturaController;
import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Utils;

/**
 *
 * @author Pedro Fernandes
 */
public class DecidirCandidaturaUI extends JFrame{
    
    private JButton btnSelExp;
    private JButton btnSelCand;
    private JButton botaoRej;
    private JButton botaoAce;
    private JComboBox comboExposicao;
    private JComboBox comboCandidatura;
    private JList jlstDecAvFAE;
    private JPanel painelNorte;
    private JPanel painelCentro;
    private static final int MARGEM_SUPERIOR = 5;
    private static final int MARGEM_INFERIOR = 5;
    private static final int MARGEM_ESQUERDA = 5;
    private static final int MARGEM_DIREITA = 5;
    private static final int JANELA_ALTURA = 500;
    private static final int JANELA_LARGURA = 900;
    
    private transient DecidirCandidaturaController controllerDCC;

    
    public DecidirCandidaturaUI(CentroExposicoes ce, Utilizador utilizador){
        
        super("Decidir Candidatura");
        
        controllerDCC = new DecidirCandidaturaController(ce, utilizador);
        
        criarComponentes();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(JANELA_LARGURA, JANELA_ALTURA));
        setSize(new Dimension(JANELA_LARGURA, JANELA_ALTURA));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void criarComponentes() {

        add(painelSul(), BorderLayout.SOUTH);
        add(painelNorte(), BorderLayout.NORTH);
        botaoAce.setEnabled(false);
        botaoRej.setEnabled(false);
        
    }
    private JPanel painelCentro(){
        painelCentro = new JPanel(new BorderLayout());
        
        jlstDecAvFAE = new JList(controllerDCC.getListaAvaliacoesFAE().getListaAvaliacoes().toArray());
        
        JPanel p = new JPanel(new GridLayout(1,2));       
        p.add(criarPainelLista("Decisão Avaliação FAE:",jlstDecAvFAE));
        
        painelCentro.add(p, BorderLayout.CENTER);
        
        return painelCentro;
    }
    private JPanel criarPainelLista(
            String tituloLista,
            JList lstLista)
    {
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());
        
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(tituloLista),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }
    private JPanel painelNorte() {
        painelNorte = new JPanel(new FlowLayout());
        
        painelNorte.add(criarPainelSelecionarExposicao(controllerDCC.getListaExposicoesOrganizador()));
        painelNorte.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        return painelNorte;
    }
    private JPanel criarPainelSelecionarExposicao(RegistoExposicoes lstExposicoes){
        JPanel painel= new JPanel(new FlowLayout());
        
        painel.setBorder(new TitledBorder("Exposição"));
        comboExposicao = Utils.criarComboExpo(lstExposicoes);
        
        painel.add(comboExposicao);              
        painel.add(criarBtSelectExp());

        return painel;
    }
    private JButton criarBtSelectExp() {
        btnSelExp=new JButton("Seleccionar");
        btnSelExp.setMnemonic(KeyEvent.VK_E);
        btnSelExp.setToolTipText("Selecionar exposição");
        btnSelExp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    btnSelExp.setEnabled(false);
                    comboExposicao.setEnabled(false);  
                    
                    controllerDCC.selectExposicao((Exposicao) comboExposicao.getSelectedItem());
                    
                    painelNorte.add(criarPainelSelecionarCandidatura(controllerDCC.getListaCandidaturasPorDecidir()));

                    btnSelCand.setEnabled(true);
                    comboCandidatura.setEnabled(true);

                    setVisible(true);
                  
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(
                           DecidirCandidaturaUI.this, 
                           "Não existem exposições com candidaturas por decidir!", 
                           "Decidir Candidatura", 
                           JOptionPane.ERROR_MESSAGE);
                   dispose();
               }
            }     
        }
        );  
        return btnSelExp;
    }
    private JPanel criarPainelSelecionarCandidatura(ListaCandidaturas lstcands){
        JPanel painel= new JPanel(new FlowLayout());
        
        painel.setBorder(new TitledBorder("Candidatura"));
        comboCandidatura = Utils.criarComboCand(lstcands);
        
        painel.add(comboCandidatura);              
        painel.add(criarBtSelectCand());
        
        btnSelCand.setEnabled(false);
        comboCandidatura.setEnabled(false);
        
        return painel;
    }
    private JButton criarBtSelectCand() {
        btnSelCand=new JButton("Seleccionar");
        btnSelCand.setMnemonic(KeyEvent.VK_C);
        btnSelCand.setToolTipText("Selecionar candidatura");
        btnSelCand.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    btnSelExp.setEnabled(false);
                    comboExposicao.setEnabled(false);  
                    
                    controllerDCC.selectCandidatura((Candidatura) comboCandidatura.getSelectedItem());

                    add(painelCentro(), BorderLayout.CENTER);

                    btnSelCand.setEnabled(false);
                    comboCandidatura.setEnabled(false);
                    botaoAce.setEnabled(true);
                    botaoRej.setEnabled(true);

                    setVisible(true);
                  
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(
                           DecidirCandidaturaUI.this, 
                           "Não existem candidaturas por decidir!", 
                           "Decidir Candidatura", 
                           JOptionPane.ERROR_MESSAGE);
                   dispose();
               }
            }     
        }
        );  
        return btnSelCand;
    }
    private JPanel painelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBotoes());
        return p;
    }   
    private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel();

        JButton bt1 = criarBotaoAceitar();
        JButton bt2 = criarBotaoRejeitar();
        JButton bt3 = criarBotaoCancelar();
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
    }
    private JButton criarBotaoAceitar() {
        botaoAce = new JButton("Aceitar");
        botaoAce.setMnemonic(KeyEvent.VK_A);
        botaoAce.setToolTipText("Aceitar candidatura");
        botaoAce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                String[] opcoes = {"ACEITAR", "Cancelar"};
                String pergunta = "ACEITAR CANDIDATURA?";
                int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                        "Confirma?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    controllerDCC.registaDecisao(true);
                    dispose();
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });

        return botaoAce;
    }
    private JButton criarBotaoRejeitar() {
        botaoRej = new JButton("Rejeitar");
        botaoRej.setMnemonic(KeyEvent.VK_R);
        botaoRej.setToolTipText("Rejeita candidatura");
        botaoRej.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opcoes = {"REJEITAR", "Cancelar"};
                String pergunta = "REJEITAR CANDIDATURA?";
                int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                        "Confirma?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    controllerDCC.registaDecisao(false);
                    dispose();
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });

        return botaoRej;
    }

    private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_C);
        botao.setToolTipText("Cancela a decisão candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return botao;
    }
    
}