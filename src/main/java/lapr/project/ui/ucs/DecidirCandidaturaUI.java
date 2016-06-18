/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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
    private JComboBox comboExposicao;
    private JComboBox comboCandidatura;
    private JList jlstCand;
    private JList jlstDecAvFAE;
    private JList jlstAVFAE;
    private JPanel painelNorte;
    private JPanel painelCentro;
    private static final int MARGEM_SUPERIOR = 5;
    private static final int MARGEM_INFERIOR = 5;
    private static final int MARGEM_ESQUERDA = 5;
    private static final int MARGEM_DIREITA = 5;
    private static final int JANELA_ALTURA = 500;
    private static final int JANELA_LARGURA = 900;
    
    
//inicio teste
    private ListaCandidaturas lstcands = new ListaCandidaturas();
    private RegistoExposicoes lstExposicoes = new RegistoExposicoes();
//fim teste
    
    public DecidirCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador){
        
        super("Decidir Candidatura");
        
        //instanciar controller
        
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
        add(painelCentro(), BorderLayout.CENTER);
    }
    private JPanel painelCentro(){
        painelCentro = new JPanel(new BorderLayout());
        
        //lstcands = controllerRCC.getCandidatura().getListaProdutos();
        ModeloListaCandidatura modeloListaCandidatura = new ModeloListaCandidatura(lstcands);
        jlstCand = new JList(modeloListaCandidatura);
        jlstDecAvFAE = new JList(modeloListaCandidatura);
        jlstAVFAE = new JList(modeloListaCandidatura);
        
        painelCentro.add(criarPainelLista("Candidaturas:",jlstCand), BorderLayout.WEST);        
        painelCentro.add(criarPainelLista("Decisão Avaliação FAE:",jlstDecAvFAE), BorderLayout.CENTER);
        painelCentro.add(criarPainelLista("Média Avaliação às Questões:",jlstAVFAE), BorderLayout.EAST);
        
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
        
        painelNorte.add(criarPainelSelecionarExposicao(lstExposicoes)); 
        painelNorte.add(criarPainelSelecionarCandidatura(lstcands));
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
                    
//                    controller.selectExposicao((Exposicao) comboExp.getSelectedItem());

                    

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
                    
//                    controller.selectCandidatura((Candidatura) comboExp.getSelectedItem());

                    //painelCentro.add()

                    btnSelCand.setEnabled(false);
                    comboCandidatura.setEnabled(false);

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
        JButton botao = new JButton("Aceitar");
        botao.setMnemonic(KeyEvent.VK_A);
        botao.setToolTipText("Aceita candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //validar aceitação e perguntar se quer fazer nova decisão
                //se sim
//                    btnSelCand.setEnabled(true);
//                    comboCandidatura.setEnabled(true);
            }
        });

        return botao;
    }
    private JButton criarBotaoRejeitar() {
        JButton botao = new JButton("Rejeitar");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Rejeita candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //validar rejeição e perguntar se quer fazer nova decisão
                //se sim
//                    btnSelCand.setEnabled(true);
//                    comboCandidatura.setEnabled(true);
            }
        });

        return botao;
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