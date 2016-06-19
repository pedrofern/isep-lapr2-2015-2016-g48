/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.Candidatura;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Tomas
 */
public class AtribuirStandCandidaturaUI extends JFrame {

    private JButton btnConfirmar, btnLimpar, btnFechar, btnAdicionarStandCandidatira,btnEleminarStandCandidatira;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 320;
    private static CentroExposicoes ce;
    private static Utilizador user;
    private JFrame framePai;
    private JList listaCandidatura, listaStands, listaStandsCandidatura;
    private DefaultListModel modelolistaCandidatura, modelolistaStands, modelolistaStandsCandidatura;
    private static final Dimension LABEL_TAMANHO = new JLabel("Listas Candidaturas Aceites").getPreferredSize();
    private JComboBox comboboxExposicao;
    private ArrayList<Candidatura> candidatura;
    private ArrayList<Stand> stands;

    public AtribuirStandCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador) {

        super("Atribuir Stand Candidatura");
        criarComponentes();
        candidatura = new ArrayList<Candidatura>();
        stands = new ArrayList<Stand>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void criarComponentes() {
        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelListas(), BorderLayout.CENTER);
        add(criarPainelSul(),BorderLayout.SOUTH);
    }

    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Selecciona uma exposição", SwingConstants.RIGHT);
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(lbl);
        p.add(getListaExposicao());
        p.setBorder(new TitledBorder("Exposição"));

        return p;
    }

    private JComboBox getListaExposicao() {

        comboboxExposicao = new JComboBox();
        comboboxExposicao.setEditable(false);
        comboboxExposicao.setSelectedIndex(-1);
        comboboxExposicao.setPreferredSize(new Dimension(200, 20));

        return comboboxExposicao;
    }

    private JPanel criarPainelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBotoes());
        return p;
    }

    private JPanel criarPainelListas() {
        JPanel p = new JPanel(new BorderLayout());

        listaCandidatura = new JList();
        modelolistaCandidatura=new DefaultListModel();
        listaCandidatura.setModel(modelolistaCandidatura);
        p.add(criarPainelListaCandidaturaAceite("Lista Candidatura Aceites", listaCandidatura));

        listaStands = new JList();
        modelolistaStands=new DefaultListModel();
        listaStands.setModel(modelolistaStands);
        p.add(criarPainelListaStand("Lista de Stands", listaStands));

        listaStandsCandidatura = new JList();
        modelolistaStandsCandidatura=new DefaultListModel();
        listaStandsCandidatura.setModel(modelolistaStandsCandidatura);
        p.add(criarPainelListaStandCandidatura("Lista de Stands | Candidatura", listaStandsCandidatura));
        return p;
    }

    private JPanel criarPainelListaCandidaturaAceite(
            String tituloLista, JList lista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

       
        p.add(scrPane, BorderLayout.WEST);

        return p;
    }

    private JPanel criarPainelListaStand(
            String tituloLista, JList lista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

      
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaStandCandidatura(
            String tituloLista, JList lista ) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
     
        p.add(scrPane, BorderLayout.EAST);
         JPanel pBotoes = criarPainelBotoes(btnAdicionarStandCandidatira, btnEleminarStandCandidatira);
       p.add(pBotoes, BorderLayout.SOUTH);
         
        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoConfirmar();
        getRootPane().setDefaultButton(btnOK);
        JButton btnClear = criarBotaoLimpar();
        JButton btnClose = criarBotaoFechar();
        JPanel p = new JPanel();
        p.add(btnOK);
        p.add(btnClose);
        p.add(btnClear);
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

    private JButton criarBotaoLimpar() {
        btnLimpar = new JButton("Limpar");
        return btnLimpar;

    }
    
     private JButton criarBotaoEliminarStandCandidatura(JList lstLista) {
         btnEleminarStandCandidatira = new JButton("Eliminar");
        
         btnEleminarStandCandidatira.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent ae) {
             }
         });
       
        
        return btnEleminarStandCandidatira;
    }

    private JButton criarBotaoAdicionarUtilizador() {

         btnAdicionarStandCandidatira = new JButton("Adicionar ");
        btnAdicionarStandCandidatira.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                
                

            }
        });

        return btnAdicionarStandCandidatira;
    }
    
}
